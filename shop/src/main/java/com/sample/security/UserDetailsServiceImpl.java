package com.sample.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sample.mapper.UserMapper;
import com.sample.mapper.UserRoleMapper;
import com.sample.vo.User;
import com.sample.vo.UserRole;

import lombok.RequiredArgsConstructor;

/*
 * UserDetailsService 인터페이스의 구현 클래스다
 * UserDetailsService 인터페이스는
 * 		 UserDetails loadUserByUsername(String username) 추상메소드가 정의되어 있다
 * 
 * UserDetailsService 인터페이스는 username을 전달받아서 인증에 필요한 사용자 정보를 UserDetails객체에 담아서 반환하는 기능을 추상화하는 인터페이스
 * 
 * 실질적인 사용자 인증작업
 * (1. username을 전달해서 사용자 인증에 필요한 UserDetails 객체를 요청하는 작업
 *  2. UserDetails 객체로 획득 사용자정보의 비밀번호와 인증 전 Authentication 객체의 credential 값을 비교해서 인증을 수행하는 작업)을 수행하는 AuthenticationProvider가
 *  UserDetailsService 구현객체를 사용한다
 *  
 *  따라서, 개발자는 AuthenticationProvider가 사용한 UserDetailsService 구현클래스를 구현할 책임이 있다
 *  
 *  GrantedAuthority은 인터페이스다
 *  SimpleGrantedAuthority는 GrantedAuthority를 구현한 구현 클래스다
 *  GrantedAuthority는 요청한 리소스에 대한 접근 여부를 결정하는 AccessDecisionManager는 리소스를 요청한 사용자의 권한을 조회할 때 GrantedAuthority 인터페이스의 getAuthorities()를 
 *  실행한다.
 *  따라서, 개발자는 사용자의 권한을 제공하기 위해서 GrantedAuthority 인터페이스를 구현한 SimpleGrantedAuthority 객체에 사용자의 권한을 담아서 제공해야한다
 */
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{
	
	private final UserMapper userMapper;
	private final UserRoleMapper userRoleMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// 사용자 정보를 조회한다
		User user = userMapper.getUserById(username);
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		
		// 사용자 정보가 존재하면 해당 사용자의 권한정보를 조회한다
		List<UserRole> userRoles = userRoleMapper.getUserRolesByUserNo(user.getNo());
		List<SimpleGrantedAuthority> authorities = getAuthorities(userRoles);
		
		// 조회된 사용자정보로 UserDetails 구현 객체를 생성한다
		return new UserDetailsImpl(user.getId(), user.getPassword(), user.getName(), authorities);
	}
	
	
	private List<SimpleGrantedAuthority> getAuthorities(List<UserRole> userRoles){
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		
		for(UserRole userRole : userRoles) {
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.getRolename());
			authorities.add(authority);
		}
		
		return authorities;
	}

	
}
