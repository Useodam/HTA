package com.sample.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderPayment {

	private int no;
	private String type;
	private String accNo;
	private int months;
	private int amount;
	private String status;
	private Date updatedDate;
	private Date createdDate;
	private Order order;
}
