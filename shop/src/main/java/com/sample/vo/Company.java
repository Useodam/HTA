package com.sample.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Company {

	private int no;
	private String name; 
	private String tel;
	private String zipcode;
	private String address1;
	private String address2;
}
