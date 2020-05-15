package com.orderManagement.service.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.orderManagement.service.entity.PaymentEntity;

/**
 * @author M1055705
 *
 */
@Repository
public interface PaymentDao extends JpaRepository<PaymentEntity, Integer>{

	@Query(value = "SELECT * FROM Payment WHERE transaction_no = ?1", nativeQuery = true)
	public PaymentEntity getPaymentByTransactionId(String transactionNo);
	
	@Query(value = "SELECT * FROM Payment WHERE user_email_id = ?1", nativeQuery = true)
	public List<PaymentEntity> getAllPaymentsByUserEmailId(String userEmailId);


}
