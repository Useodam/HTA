package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.mapper.CompanyMapper;
import com.sample.vo.Company;

@Service
public class CompanyService {

	@Autowired
	private CompanyMapper companyMapper;
	
	public List<Company> getAllCompanies() {
		return companyMapper.getAllCompanies();
	}
	
}
