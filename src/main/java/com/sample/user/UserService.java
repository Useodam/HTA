package com.sample.user;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/*
 * UserRepository userRepository
 * 		- userRepository 프로퍼티는 UserRepository 인터페이스 타입의 객체를 의존성 주입받는다
 * 		- UserRepository 인터페이스 타입
 * 		- userRepository 프로퍼티에는 UserRepository 인터페이스의 구현객체가 의존성 주입된다
 * 		- UserRepository 인터페이스의 구현객체는 Spring Data JPA가 JPA 구현객체를 이용해서 구현하고, 스프링 컨테이너의 빈으로 등록한다
 */

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	/**
	 * 신규 사용자 정보가 저장된 UserSignupForm 객체를 전달받아서 사용자 정보를 회원가입 시킨다
	 * @param form 신규 사용자 정보가 포함된 UserSignupForm 객체
	 * @return 데이터베이스에 등록된 사용자 정보가 포함된 User 객체
	 */
	public User registerUser(UserSignupForm form) {
		if(userRepository.existsByUsername(form.getId())) {
			throw new RuntimeException("id");
		}
		
		if(userRepository.existsByEmail(form.getEmail())) {
			throw new RuntimeException("email");
		}
		
		User user = form.toEntity(passwordEncoder);
		return userRepository.save(user);
		
		
	}

	/**
	 * 사용자 기본키값을 전달받아서 사용자정보를 반환한다
	 * @param id 사용자 기본키 값
	 * @return 조회된 사용자 정보가 포함된 User객체, 만약 사용자 정보가 존재하지 않으면 NoSuchElementException 예외를 던진다
	 */
	public User getUser(Long id) {
		Optional<User> optional = userRepository.findById(id);
		return optional.orElseThrow();
	}
}
