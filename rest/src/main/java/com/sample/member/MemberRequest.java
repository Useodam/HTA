package com.sample.member;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberRequest {
	
	private String email;
	private String password;
	private	String name;
	private String tel;
	
	public Member toEntity() {
		Member member = new Member();
		member.setEmail(email);
		member.setPassword(password);
		member.setName(name);
		member.setTel(tel);
		member.setCreatedDate(LocalDateTime.now());
		
		return member;
	}

}
