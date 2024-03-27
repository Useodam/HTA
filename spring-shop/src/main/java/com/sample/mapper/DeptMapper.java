package com.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sample.vo.Dept;

@Mapper
public interface DeptMapper {
	
	List<Dept> getAllDepts();

	void createDepts(Dept dept);

}
