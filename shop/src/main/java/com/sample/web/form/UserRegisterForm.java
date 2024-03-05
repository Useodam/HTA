package com.sample.web.form;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRegisterForm {
	
	@NotBlank(message = "아이디는 필수 입력값입니다")
	@Size(min = 6, max = 30, message = "아이디는 최소 6자, 최대 30자 까지 가능합니다")
	private String id;
	
	@NotBlank(message = "비밀번호는 필수 입력값입니다")
	@Size(min = 8, message = "비밀번호는 최소 8글자 이상만 가능합니다")
	private String password;
	
	@NotBlank(message = "이름은 필수 입력값입니다")
	private String name;
	
	@NotBlank(message = "이메일은 필수 입력값입니다")
	@Email(message = "유효한 형식의 이메일이 아닙니다")
	private String email;
	
	@NotBlank(message = "전화번호는 필수 입력값입니다")
	private String tel;
	
	@NotNull(message = "생일은 필수 입력값입니다")
	@Past(message = "생일은 오늘보다 이전 날짜만 가능합니다")
	private Date birth;
}
