package com.sample.web.form;

import com.sample.vo.Emp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpModifyForm extends EmpCreateForm {

	private int no;
	
	@Override
	public Emp toEmp() {
		Emp emp = super.toEmp();
		emp.setNo(no);
		
		return emp;
	}
	
}
