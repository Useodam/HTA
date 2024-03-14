package com.sample.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductCategory {

	private int no;
	private String name;
	
	public ProductCategory(int no) {
		this.no = no;
	}
}
