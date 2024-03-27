package com.sample.web.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

	private int no;
	private String id;
	private String name;
	private String tel;
	private String email;
	@JsonFormat(pattern = "MM월 dd일")
	private Date birth;
	@JsonFormat(pattern = "yyyy년 MM월 dd일")
	private Date createdDate;
}
