package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.mapper.DeptMapper;
import com.sample.vo.Dept;
import com.sample.web.form.DeptCreateForm;

@Service
public class HrService {

	@Autowired
	private DeptMapper deptMapper;
	
	public List<Dept> getAllDepts() {
		return deptMapper.getAllDepts();
	}

	public void createDept(DeptCreateForm form) {
		Dept dept = Dept.builder()
//		dept.setName(form.getName());
//		dept.setTel(form.getTel());
//		dept.setFax(form.getFax());
		.name(form.getName())
		.tel(form.getTel())
		.fax(form.getFax())
		.build();
		
		deptMapper.createDepts(dept);
		 
	}
}
