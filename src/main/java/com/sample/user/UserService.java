package com.sample.user;

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
	
	/**
	 * 신규 사용자 정보가 저장된 UserSignupForm 객체를 전달받아서 사용자 정보를 회원가입 시킨다
	 * @param form 신규 사용자 정보가 포함된 UserSignupForm 객체
	 * @return 데이터베이스에 등록된 사용자 정보가 포함된 User 객체
	 */
	public User registerUser(UserSignupForm form) {
		userRepository.ex
		User user = form.toEntity();
		return userRepository.save(user);
		
		
	}
}
