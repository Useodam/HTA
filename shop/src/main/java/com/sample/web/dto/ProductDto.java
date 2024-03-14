package com.sample.web.dto;

import com.sample.vo.Company;
import com.sample.vo.ProductCategory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProductDto {

	private int no;
	private ProductCategory category;	// 카테고리명을 받아와야하니 productCategory.name
	private String name;
	private Company company;	// 제조사명을 받아와야하니 company.name
	private int price;
	private int stock;
	private String status;
	private String description;
}
