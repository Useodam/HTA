package com.sample.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;
	
	@Test
	@DisplayName("UserRepository 구현객체는 Null이 아니다")
	public void testConfig() {
		assertThat(userRepository).isNotNull();
	}
	
	@Test
	public void testSaveUser() {
		User user = new User();
		user.setUsername("hong");
		user.setPassword("zxcv1234");
		user.setName("홍길동");
		user.setEmail("hong@gmail.com");
		user.setTel("010-2222-2222");
		
		userRepository.save(user);
		List<User> users = userRepository.findAll();
		
		assertThat(users.size()).isEqualTo(1);
		
	}
}
