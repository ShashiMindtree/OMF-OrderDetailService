package com.orderManagement.service.serviceImplTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.util.Assert;

import com.orderManagement.service.dao.OrderDetailDao;
import com.orderManagement.service.entity.OrderDetail;
import com.orderManagement.service.serviceImpl.OrderDetailServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class OrderDetailServiceImplTest {
	
	@Mock
	private OrderDetailDao orderDetailDao;;
	
	@InjectMocks
	private OrderDetailServiceImpl orderDetailServiceImpl;
	
	
	@Test
	public void testAddOrder() {
		OrderDetail buildData = build();
		when(orderDetailDao.save(buildData)).thenReturn(buildData);
		OrderDetail save = orderDetailServiceImpl.save(buildData);
		assertNotNull(save);
	}
	
	@Test
	public void testUpdateOrder() {
		OrderDetail buildData = build();
		when(orderDetailDao.save(buildData)).thenReturn(buildData);
		OrderDetail orderDetail = orderDetailServiceImpl.updateDetail(buildData);
		assertNotNull(orderDetail);
	}
	
	@Test
	public void testFindById() {
		OrderDetail buildData = build();
		when(orderDetailDao.findById(1).get()).thenReturn(buildData);
		OrderDetail findById = orderDetailServiceImpl.findById(1);
		assertNotNull(findById);
	}
	
	@Test
	public void testGetAllOrderDetailByUserId() {
		List<OrderDetail> listData = new ArrayList<>();
		OrderDetail buildData = build();
		listData.add(buildData);
		when(orderDetailDao.getAllOrderDetailByUserId(buildData.getUserId())).thenReturn(listData);
		List<OrderDetail> findAll = orderDetailServiceImpl.getAllOrderDetailByUserId(buildData.getUserId());
		Assert.isTrue(findAll.size() > 0);
	}
	
	
	private OrderDetail build() {
		OrderDetail buildData = new OrderDetail();
		buildData.setUserId("userId");
		buildData.setOrderDetail("orderDetail");
		return buildData;
	}

}
