package com.orderManagement.service.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.orderManagement.service.entity.PaymentEntity;

/**
 * @author M1055705
 *
 */
@Component
public interface PaymentService {
	public PaymentEntity save(PaymentEntity payment);

	public PaymentEntity updatepayment(PaymentEntity payment);

	public PaymentEntity getPaymentBytransactionId(String transactionId);

	public List<PaymentEntity> getAllPaymentsByUserEmailId(String userEmailId);

}
