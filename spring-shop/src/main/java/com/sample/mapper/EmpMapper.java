package com.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sample.vo.Emp;

@Mapper
public interface EmpMapper {

	List<Emp> getAllEmployees();
	
	void createEmployees(Emp emp);

	Emp getProductByNo(int no);

	void updateEmployee(Emp emp);
}
