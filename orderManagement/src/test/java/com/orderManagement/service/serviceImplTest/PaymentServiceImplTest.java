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

import com.orderManagement.service.dao.PaymentDao;
import com.orderManagement.service.entity.PaymentEntity;
import com.orderManagement.service.serviceImpl.PaymentServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceImplTest {
	
	@Mock
	private PaymentDao paymentDao;
	
	@InjectMocks
	private PaymentServiceImpl paymentServiceImpl;
	
	
	@Test
	public void testSave() {
		PaymentEntity buildData = build();
		when(paymentDao.save(buildData)).thenReturn(buildData);
		PaymentEntity save = paymentServiceImpl.save(buildData);
		assertNotNull(save);
	}
	
	@Test
	public void testUpdate() {
		PaymentEntity buildData = build();
		when(paymentDao.save(buildData)).thenReturn(buildData);
		PaymentEntity paymentEntity = paymentServiceImpl.updatepayment(buildData);
		assertNotNull(paymentEntity);
	}
	
	@Test
	public void testGetPaymentBytransactionId() {
		PaymentEntity buildData = build();
		when(paymentDao.getPaymentByTransactionId(buildData.getTransactionNo())).thenReturn(buildData);
		PaymentEntity findById = paymentServiceImpl.getPaymentBytransactionId(buildData.getTransactionNo());
		assertNotNull(findById);
	}
	
	@Test
	public void testGetAllPaymentsByUserEmailId() {
		List<PaymentEntity> listData = new ArrayList<>();
		PaymentEntity buildData = build();
		listData.add(buildData);
		when(paymentDao.getAllPaymentsByUserEmailId(buildData.getUserEmailId())).thenReturn(listData);
		List<PaymentEntity> findAll = paymentServiceImpl.getAllPaymentsByUserEmailId(buildData.getUserEmailId());
		Assert.isTrue(findAll.size() > 0);
	}
	
	
	private PaymentEntity build() {
		PaymentEntity buildData = new PaymentEntity();
		buildData.setAmount(1);
		buildData.setOrderNo("orderDetailno");
		buildData.setUserEmailId("userEmailId");
		buildData.setTransactionNo("transactionNo");
		return buildData;
	}

}
