package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.mapper.EmpMapper;
import com.sample.vo.Dept;
import com.sample.vo.Emp;
import com.sample.web.form.EmpCreateForm;
import com.sample.web.form.EmpModifyForm;

@Service
public class EmployeeService {

	@Autowired
	private EmpMapper empMapper;
	
	public List<Emp> getAllEmployees() {
		return empMapper.getAllEmployees();
	}

	public void createEmployee(EmpCreateForm form) {
		Emp emp = form.toEmp();
		empMapper.createEmployees(emp);
		
	}

	public Emp getEmployeeDetail(int no) {
		return empMapper.getProductByNo(no);
	}

	public void updateEmployee(EmpModifyForm form) {
		Emp emp = form.toEmp();
		empMapper.updateEmployee(emp);
	}
}
