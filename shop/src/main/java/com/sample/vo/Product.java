package com.sample.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product {

	private int no;
	private String name; 
	private String description;
	private int stock;
	private String status;
	private int price;
	private String filename;
	private Date updatedDate;
	private Date createdDate;
	private Company company;
	private ProductCategory category;
	
	
}
