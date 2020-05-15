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
@Table(name = "Payment")
public class PaymentEntity {

	@Id
	@Column(name = "id")
	@ApiModelProperty(notes = "id", name = "id", required = true, value = "test id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "order_no")
	@ApiModelProperty(notes = "orderNo", name = "orderNo", required = true, value = "orderNo")
	private String orderNo;

	@Column(name = "user_email_id")
	@ApiModelProperty(notes = "userEmailId", name = "userEmailId", required = true, value = "userEmailId")
	private String userEmailId;

	@Column(name = "amount")
	@ApiModelProperty(notes = "amount", name = "amount", required = true, value = "amount")
	private double amount;

	@Column(name = "status")
	@ApiModelProperty(notes = "status", name = "status", required = true, value = "status")
	private String status;

	@Column(name = "transaction_no")
	@ApiModelProperty(notes = "transactionNo", name = "transactionNo", required = true, value = "transactionNo")
	private String transactionNo;

	@Column(name = "transaction_mode")
	@ApiModelProperty(notes = "transactionMode", name = "transactionMode", required = true, value = "transactionMode")
	private String transactionMode;
	
	@Column(name = "transaction_time")
	@ApiModelProperty(notes = "transactionTime", name = "transactionTime", required = true, value = "transactionTime")
	private LocalDateTime transactionTime;

}
