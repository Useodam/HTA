package com.sample.user;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{

	private final UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> optional = userRepository.findByUsername(username);
		/*
		 * Optional<T>의 orElseThrow() 메소드
		 * 		- Optional 객체에 T타입의 객체가 존재하면 그 객체를 반환한다
		 * 		- Optional 객체에 T타입의 객체가 존재하지 않으면 예외를 던진다
		 * 		- 사용예
		 * 			User user = optional.orElseThrow();
		 * 				+ Optional객체에 User객체가 존재하면 User객체를 반환하고, 존재하지 않으면 NoSuchElementException 예외를 던진다
		 * 
		 * 			User user = optional.orElseThrow(() -> 사용자정의예외객체);
		 * 				+ Optional객체에 User객체가 존재하면 User객체를 반환하고, 존재하지 않으면 사용자정의예외객체 예외를 던진다
		 * 		
		 * 		- orElseThrow(Supplier<? extends X> exceptionSupplier)
		 * 			+ Supplier객체를 매개변수로 전달해야한다. Supplier은 인터페이스다
		 * 			+ orElseThrow(new Supplier() {
		 * 				public UsernameNotFoundException get() {
		 * 					return new UsernameNotFoundException("사용자를 찾을 수 없습니다");
		 * 				}
		 * 			})
		 * 			+ orElseThrow(()-> 구현코드)
		 * 		 
		 * */
		User user = optional.orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다"));
		
		UserDetailsImpl userDetails = new UserDetailsImpl();
		userDetails.setUsername(user.getUsername());
		userDetails.setPassword(user.getPassword());
		
		/*
	       * authorities
	       *       + Collection<? extends GrantedAuthorites> 타입이다.
	       * 
	       *       + user.getUserRole()은 UserRole 열거형 상수데이터를 반환한다. UserRole.ROLE_USER 혹은 UserRole.ROLE_ADMIN 중 하나다.
	       *       + user.getUserRole().name()은 상수데이터의 이름값을 반환한다. "ROLE_USER" 혹은 "ROLE_ADMIN" 중 하나다.
	       *       + new SimpleGrantedAuthority("보유권한이름")은 사용자가 보유한 권한을 표현하는 객체를 생성한다.
	       *       + new SimpleGrantedAuthority(user.getUserRole().name()))는 
	       *          new SimpleGrantedAuthority("ROLE_USER")
	       *          new SimpleGrantedAuthority("ROLE_ADMIN") 중 하나다.
	       *       + List.of(객체, 객체, 객체)는 지정된 객체가 저장된 List객체를 생성한다.
	       */
		userDetails.setAuthorities(List.of(new SimpleGrantedAuthority(user.getUserRole().name())));
		
		
		return userDetails;
	}
}
