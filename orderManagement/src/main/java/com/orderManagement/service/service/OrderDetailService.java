package com.orderManagement.service.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.orderManagement.service.entity.OrderDetail;

/**
 * @author M1055705
 *
 */
@Component
public interface OrderDetailService {
	
	public OrderDetail save(OrderDetail orderDetail);

	public OrderDetail updateDetail(OrderDetail orderDetail);

	public OrderDetail findById(int orderId);

	public List<OrderDetail> getAllOrderDetailByUserId(String orderId);
	
}
