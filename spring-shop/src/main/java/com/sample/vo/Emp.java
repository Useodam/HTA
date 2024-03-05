package com.sample.vo;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
public class Emp {

	private int no;
	private String name;
	private String tel;
	private String email;
	private int salary;
	private Date hireDate;
	private Dept dept;
	private Date createdDate;
	private Date updatedDate;
	
	public Emp(int no, String name, String tel, String email, int salary, Date hireDate, Dept dept, Date createdDate,
			Date updatedDate) {
		super();
		this.no = no;
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.salary = salary;
		this.hireDate = hireDate;
		this.dept = dept;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	
	
	
}
