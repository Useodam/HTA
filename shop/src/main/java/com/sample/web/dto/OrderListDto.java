package com.sample.web.dto;

import java.util.Date;
import java.util.List;

import com.sample.vo.OrderItem;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderListDto {

	private int orderNo;
	private Date orderDate;
	private int totalPrice;
	
	
	private List<OrderItem> items;
	
	public String getDescription() {
		if (items.isEmpty()) {
			return null;
		}
		return items.get(0).getProduct().getName() + " 외";
	}
}
