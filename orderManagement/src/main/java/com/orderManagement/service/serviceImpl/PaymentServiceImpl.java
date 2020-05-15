package com.orderManagement.service.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderManagement.service.dao.PaymentDao;
import com.orderManagement.service.entity.PaymentEntity;
import com.orderManagement.service.service.PaymentService;

/**
 * @author M1055705
 *
 */
@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDao paymentDao;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public PaymentEntity save(PaymentEntity payment) {
		PaymentEntity save = new PaymentEntity();
		try {
			payment.setTransactionTime(LocalDateTime.now());
			payment.setTransactionNo(generateTransactionNo(payment));
			save = paymentDao.save(payment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return save;

	}

	@Override
	public PaymentEntity updatepayment(PaymentEntity payment) {
		PaymentEntity update = new PaymentEntity();
		try {
			update = paymentDao.save(payment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return update;
	}

	@Override
	public PaymentEntity getPaymentBytransactionId(String transactionId) {
		PaymentEntity paymentByTransactionId = new PaymentEntity();
		try {
			paymentByTransactionId = paymentDao.getPaymentByTransactionId(transactionId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return paymentByTransactionId;
	}

	@Override
	public List<PaymentEntity> getAllPaymentsByUserEmailId(String emailId) {
		List<PaymentEntity> allPaymentsByUserEmailId = new ArrayList<>();
		try {
			allPaymentsByUserEmailId = paymentDao.getAllPaymentsByUserEmailId(emailId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allPaymentsByUserEmailId;
	}

	private String generateTransactionNo(PaymentEntity paymentEntity) {
		Random rand = new Random();
		int randNum = rand.nextInt(1000);
		return "TXN".concat("-") + randNum;
	}

}
