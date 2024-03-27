package com.sample.web.dto;


import java.util.List;

import com.sample.vo.Order;
import com.sample.vo.OrderItem;
import com.sample.vo.OrderPayment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDetailDto {

	private Order order;
	private List<OrderItem> orderItems;
	private OrderPayment payment;
	
	public String getDescription() {
		if (orderItems.isEmpty()) {
			return null;
		}
		return orderItems.get(0).getProduct().getName() + " 외";
	}
}
