package com.sample.web.form;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductCreateForm {
	
	private int companyNo;
	private String name;
	private int price;
	private int stock;
	private MultipartFile photofile; // 스프링에서 첨부파일 업로드를 담당
	private String description;
	

}
