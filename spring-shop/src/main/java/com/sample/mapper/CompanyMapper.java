package com.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sample.vo.Company;

@Mapper
public interface CompanyMapper {

	List<Company> getAllCompanies();
}
