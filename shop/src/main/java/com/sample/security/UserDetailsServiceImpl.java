package com.sample.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sample.mapper.UserMapper;
import com.sample.vo.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{
	
	private final UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userMapper.getUserById(username);
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		
		return new UserDetailsImpl(user.getId(), user.getPassword(), user.getName(), List.of(new SimpleGrantedAuthority("ROLE_USER")));
	}
	
	

	
}
