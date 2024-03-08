package com.sample.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sample.exception.AlreadyUsedEmailException;
import com.sample.exception.AlreadyUsedIdException;
import com.sample.mapper.UserMapper;
import com.sample.mapper.UserRoleMapper;
import com.sample.vo.User;
import com.sample.vo.UserRole;
import com.sample.web.form.UserRegisterForm;

import lombok.RequiredArgsConstructor;

/*
 * @RequiredArgsConstructor
 * 		- 초기화가 필요한 멤버변수를 매개변수로 가지는 생성자 메소드를 자동으로 추가한다
 * 			* final 키워드가 지정되어 있는 멤버변수는 반드시 초기화가 필요하다
 * 			* final 키워드가 지정되어 있는 멤버변수를 초기화하는 방법은 2가지가 있다
 * 				- 멤버변수에 직접 값을 대입하기
 * 				- 생성자 메소드의 초기화작업으로 값을 대입하기
 * 		- 스프링에서 의존성 주입이 필요한 멤버변수에 final 키워드를 지정하고,
 * 			@RequiredArgsConstructor를 클래스에 추가하면
 * 			스프링 컨테이너가 자동으로 의존성을 주입한다
 */

@Service
@RequiredArgsConstructor
public class UserService {
	
	// 회원가입시 비밀번호 암호화를 위해서 passwordEncoder 구현객체를 주입받는다
	private final PasswordEncoder passwordEncoder;
	private final UserMapper userMapper;
	private final UserRoleMapper userRoleMapper;
	
	/*
	 * 신규 회원가입 서비스를 제공하는 메소드다
	 * 		- 신규 가입 프로세스
	 * 			1. 회원아이디로 회원정보를 조회한다. 회원정보가 존재하면 예외를 발생시킨다
	 * 			2. 이메일로 회원정보를 조회한다. 회원정보가 존재하면 예외를 발생시킨다
	 * 			3. UserRegisterForm객체에 저장된 신규 회원정보로 User객체를 생성한다
	 * 			4. 비밀번호를 암호화하고, 암호화된 비밀번호를 저장한다
	 * 			5. 신규 회원정보가 저장된 User객체를 mybatis에 전달해서 저장시킨다
	 * 			6. 신규 회원은 ROLE_USER 권한을 부여하기 위해서 UserRole 객체를 생성해서 사용자번호와 "ROLE_USER"객체를 대입한다
	 * 			7. 신규 회원의 권한 정보가 저장된 UserRole객체를 mybatis에 전달해서 데이터베이스에 저장시킨다
	 */
	public void registerUser(UserRegisterForm form) {
		User foundUser = userMapper.getUserById(form.getId());
		if(foundUser != null) {
			throw new AlreadyUsedIdException("[" + form.getId()+"]는 이미 사용중인 아이디입니다");
		}
		
		foundUser = userMapper.getUserByEmail(form.getEmail());
		if(foundUser != null) {
			throw new AlreadyUsedEmailException("[" + form.getEmail()+"]는 이미 사용중인 이메일입니다");
		}
		
		User user = form.toUser();
		
		// 비밀번호 암호화
		String secretPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(secretPassword);
		userMapper.insertUser(user);
		
		UserRole userRole = new UserRole();
		userRole.setUserNo(user.getNo());
		userRole.setRolename("ROLE_USER");
		
		userRoleMapper.insertUserRole(userRole);
	}
	
	public User getUser(String id) {
		return userMapper.getUserById(id);
	}
	
}

