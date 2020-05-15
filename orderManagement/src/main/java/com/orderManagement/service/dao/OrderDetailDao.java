package com.orderManagement.service.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.orderManagement.service.entity.OrderDetail;

/**
 * @author M1055705
 *
 */
@Repository
public interface OrderDetailDao extends JpaRepository<OrderDetail, Integer> {

	@Query(value = "SELECT * FROM Order_detail WHERE users_id = ?1", nativeQuery = true)
	public List<OrderDetail> getAllOrderDetailByUserId(String userId);

}
