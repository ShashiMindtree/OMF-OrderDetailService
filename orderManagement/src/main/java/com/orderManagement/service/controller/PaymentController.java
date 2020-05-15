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

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.orderManagement.service.entity.PaymentEntity;
import com.orderManagement.service.service.PaymentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author M1055705
 *
 */
@RestController
@RequestMapping(value = "/payments/v1")
@Api(value = "PaymentController", description = "Payment REST Apis")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@ApiOperation(value = "save payment ", response = PaymentEntity.class, tags = "save")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess|OK"),
	@ApiResponse(code = 401, message = "not authorized!"),
	@ApiResponse(code = 404, message = "not found!!!") })
	@PostMapping(value = "/add")
	public ResponseEntity<PaymentEntity> save(@RequestBody PaymentEntity payments) {
		PaymentEntity saved = new PaymentEntity();
		try {
			saved = paymentService.save(payments);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saved != null ? new ResponseEntity<PaymentEntity>(HttpStatus.OK)
				: new ResponseEntity<PaymentEntity>(HttpStatus.BAD_REQUEST);

	}

	@ApiOperation(value = "update payment ", response = PaymentEntity.class, tags = "update")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), 
			@ApiResponse(code = 404, message = "not found!!!") })

	@PutMapping(value = "/update")
	public ResponseEntity<PaymentEntity> update(@RequestBody PaymentEntity payments) {
		PaymentEntity updatepayment = new  PaymentEntity();
		try {
			updatepayment = paymentService.updatepayment(payments);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return updatepayment != null ? new ResponseEntity<PaymentEntity>(HttpStatus.OK)
				: new ResponseEntity<PaymentEntity>(HttpStatus.BAD_REQUEST);
	}

	@ApiOperation(value = "get payment by transaction id", response = PaymentEntity.class, tags = "get")
	@GetMapping(value = "/get/{transactionId}")
	public PaymentEntity getById(@PathVariable(name = "transactionId") String transactionId) {
		PaymentEntity paymentBytransactionId = new PaymentEntity();
		try {
			paymentBytransactionId = paymentService.getPaymentBytransactionId(transactionId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return paymentBytransactionId;
	}

	@ApiOperation(value = "get all payment related to user by user is", response = PaymentEntity.class, tags = "get")
	@GetMapping(value = "/getAll/{userEmailId}")
	@HystrixCommand(fallbackMethod = "fallbackPayment", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000") })

	public List<PaymentEntity> getPaymentsByUserEmailId(@PathVariable(name = "userEmailId") String userEmailId)
			throws InterruptedException {
		List<PaymentEntity> allPaymentsByUserEmailId = new ArrayList<>();
		try {
			//Thread.sleep(3000);
			allPaymentsByUserEmailId = paymentService.getAllPaymentsByUserEmailId(userEmailId);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return allPaymentsByUserEmailId;
	}

	private List<PaymentEntity> fallbackPayment(String userEmailId) {
		return new ArrayList<>();
	}

}
