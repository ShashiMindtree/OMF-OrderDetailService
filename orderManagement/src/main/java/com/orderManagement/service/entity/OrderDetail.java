package com.orderManagement.service.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author M1055705
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "Order_detail")
public class OrderDetail {

	@Id
	@Column(name = "id")
	@ApiModelProperty(notes = "id", name = "id", required = true, value = "test id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name = "restuarant_id")
	@ApiModelProperty(notes = "restuarantId", name = "restuarantId", required = true, value = "restuarantId")
	private String restuarantId;

	@Column(name = "users_id")
	@ApiModelProperty(notes = "userId", name = "userId", required = true, value = "userId")
	private String userId;
	
	@Column(name = "email_id")
	@ApiModelProperty(notes = "emailId", name = "emailId", required = true, value = "emailId")
	private String emailId;

	@Column(name = "restuarant_name")
	@ApiModelProperty(notes = "restuarantName", name = "restuarantName", required = true, value = "restuarantName")
	private String restuarantName;

	@Column(name = "order_no")
	@ApiModelProperty(notes = "orderNo", name = "orderNo", required = true, value = "orderNo")
	private String orderNo;

	@Column(name = "rating")
	@ApiModelProperty(notes = "rating", name = "rating", required = true, value = "rating")
	private double rating;

	@Column(name = "customer_name")
	@ApiModelProperty(notes = "customerName", name = "customerName", required = true, value = "customerName")
	private String customerName;

	@Column(name = "order_detail")
	@ApiModelProperty(notes = "orderDetail", name = "orderDetail", required = true, value = "orderDetail")
	private String orderDetail;

	@Column(name = "amount")
	@ApiModelProperty(notes = "amount", name = "amount", required = true, value = "amount")
	private double amount;

	@Column(name = "delivery_address")
	@ApiModelProperty(notes = "deliveryAddress", name = "deliveryAddress", required = true, value = "deliveryAddress")
	private String deliveryAddress;

	@Column(name = "reviews")
	@ApiModelProperty(notes = "reviews", name = "reviews", required = true, value = "reviews")
	private String reviews;

	@Column(name = "ordered_time")
	@ApiModelProperty(notes = "orderedTime", name = "orderedTime", required = true, value = "orderedTime")
	private LocalDateTime orderedTime;

	@Column(name = "delivered_time")
	@ApiModelProperty(notes = "deliveredTime", name = "deliveredTime", required = true, value = "deliveredTime")
	private LocalDateTime deliveredTime;

	@Column(name = "delivered_by")
	@ApiModelProperty(notes = "deliveredBy", name = "deliveredBy", required = true, value = "deliveredBy")
	private String deliveredBy;

	@Column(name = "status")
	@ApiModelProperty(notes = "status", name = "status", required = true, value = "status")
	private String status;

	@Column(name = "qty")
	@ApiModelProperty(notes = "qty", name = "qty", required = true, value = "qty")
	private int qty;

}
