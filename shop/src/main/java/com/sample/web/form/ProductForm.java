package com.sample.web.form;


import com.sample.vo.Company;
import com.sample.vo.Product;
import com.sample.vo.ProductCategory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductForm {

	private int categoryNo;
	private String name;
	private int companyNo;
	private int price;
	private int amount;
	private String description;
	
	public Product toProduct() {
		Product product = new Product();
		product.setCategory(new ProductCategory(categoryNo));
		product.setCompany(new Company(companyNo));
		product.setName(name);
		product.setPrice(price);
		product.setStock(amount);
		product.setDescription(description);
		
		return product;
		
		
	}
}
