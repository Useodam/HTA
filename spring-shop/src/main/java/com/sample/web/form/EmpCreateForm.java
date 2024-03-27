package com.sample.web.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.sample.vo.Dept;
import com.sample.vo.Emp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpCreateForm {

	private String name;
	private String tel;
	private String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hireDate;
	private int salary;
	private int deptNo;
	
	public Emp toEmp() {
		Emp emp = new Emp();
		emp.setName(name);
		emp.setTel(tel);
		emp.setEmail(email);
		emp.setSalary(salary);
		emp.setHireDate(hireDate);
		
		Dept dept = new Dept();
		dept.setNo(deptNo);
		emp.setDept(dept);
		
		return emp;
		
	}
}
