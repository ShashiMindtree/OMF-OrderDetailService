package com.orderManagement.service.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.orderManagement.service.dao.OrderDetailDao;
import com.orderManagement.service.entity.OrderDetail;
import com.orderManagement.service.enums.OrderStatusEnum;
import com.orderManagement.service.service.OrderDetailService;

/**
 * @author M1055705
 *
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	private OrderDetailDao orderDetailDao;

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Override
	public OrderDetail save(OrderDetail orderDetail) {
		OrderDetail saved = new OrderDetail();
		try {
			orderDetail.setOrderedTime(LocalDateTime.now());
			orderDetail.setOrderNo(generateOrderNo(orderDetail));
			orderDetail.setStatus(OrderStatusEnum.OrderConfirmed.toString());
			saved = orderDetailDao.save(orderDetail);
			if (saved != null) {
				sendMessage(saved.getUserId() + "/" + saved.getStatus() + "/" + saved.getEmailId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saved;
	}

	@Override
	public OrderDetail updateDetail(OrderDetail orderDetail) {
		OrderDetail update = new OrderDetail();
		try {
			update = orderDetailDao.save(orderDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return update;
	}

	@Override
	public OrderDetail findById(int orderId) {
		OrderDetail orderDetail = new OrderDetail();
		try {
			orderDetail = orderDetailDao.findById(orderId).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderDetail;
	}

	@Override
	public List<OrderDetail> getAllOrderDetailByUserId(String userId) {
		List<OrderDetail> allOrderDetailByUserId = new ArrayList<>();
		try {
			allOrderDetailByUserId = orderDetailDao.getAllOrderDetailByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allOrderDetailByUserId;
	}


	private String generateOrderNo(OrderDetail orderDetail) {
		Random rand = new Random();
		int randNum = rand.nextInt(1000);
		return orderDetail.getRestuarantId().concat("-") + randNum;
	}

	public void sendMessage(String msg) {
		try {
			kafkaTemplate.send("email", msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
