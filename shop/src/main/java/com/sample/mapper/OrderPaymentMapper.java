package com.sample.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.sample.vo.OrderPayment;

@Mapper
public interface OrderPaymentMapper {

	void insertPayment(OrderPayment orderPayment);
	OrderPayment getOrderPaymentByOrderNo(int orderNo);
}
