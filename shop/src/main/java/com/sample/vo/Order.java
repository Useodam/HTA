package com.sample.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Order {

	private int no;
	private Date orderDate;
	private User user;
	private int totalPrice;
	private String status;
	private Date updatdDate;
}
