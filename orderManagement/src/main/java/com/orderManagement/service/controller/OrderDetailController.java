package com.orderManagement.service.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderManagement.service.entity.OrderDetail;
import com.orderManagement.service.service.OrderDetailService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author M1055705
 *
 */
@RestController
@RequestMapping(value = "/orderdetail/v1")
@Api(value = "OrderDetailController", description = "order Detail REST Apis")
public class OrderDetailController {

	@Autowired
	private OrderDetailService orderDetailService;

	@ApiOperation(value = "save order detail ", response = OrderDetail.class, tags = "save")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess|OK"),
	@ApiResponse(code = 401, message = "not authorized!"), 
	@ApiResponse(code = 404, message = "not found!!!") })
	@PostMapping(value = "/add")
	public ResponseEntity<OrderDetail> save(@RequestBody OrderDetail orderDetail) {
		OrderDetail order = new OrderDetail();
		try {
			 order = orderDetailService.save(orderDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return order != null ? new ResponseEntity<OrderDetail>(HttpStatus.OK)
				: new ResponseEntity<OrderDetail>(HttpStatus.BAD_REQUEST);

	}

	@ApiOperation(value = "update order detail ", response = OrderDetail.class, tags = "update")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"),
			@ApiResponse(code = 404, message = "not found!!!") })

	@PutMapping(value = "/update")
	public ResponseEntity<OrderDetail> update(@RequestBody OrderDetail orderDetail) {
		OrderDetail updated = new OrderDetail();
		try {
			updated = orderDetailService.updateDetail(orderDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return updated != null ? new ResponseEntity<OrderDetail>(HttpStatus.OK)
				: new ResponseEntity<OrderDetail>(HttpStatus.BAD_REQUEST);
	}

	@ApiOperation(value = "get order detail by order id", response = OrderDetail.class, tags = "get")
	@GetMapping(value = "/get/{orderId}")
	public OrderDetail getById(@PathVariable(name = "orderId") int orderId) {
		OrderDetail findById = new OrderDetail();
		try {
			findById = orderDetailService.findById(orderId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return findById;
	}

	@ApiOperation(value = "get all user order detail by user id", response = OrderDetail.class, tags = "getAll")
	@GetMapping(value = "/getAll/{userId}")
	public List<OrderDetail> getOrderDetailByUserId(@PathVariable(name = "userId") String userId) {
		List<OrderDetail>  allOrderDetailByUserId = new ArrayList<>();
		try {
			 allOrderDetailByUserId = orderDetailService.getAllOrderDetailByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allOrderDetailByUserId;
	}

}
