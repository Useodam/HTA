package com.sample.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
public class Dept {

	private int no;
	private String name;
	private String tel;
	private String fax;
	
	@Builder
	public Dept(int no, String name, String tel, String fax) {
		super();
		this.no = no;
		this.name = name;
		this.tel = tel;
		this.fax = fax;
	}
	
	
	
	
	
	
}
