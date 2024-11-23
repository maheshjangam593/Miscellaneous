package com.example.demo.service;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	private int id;
	private Date orderPlacedDate;
	private String transactionId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrderPlacedDate() {
		return orderPlacedDate;
	}

	public void setOrderPlacedDate(Date date) {
		this.orderPlacedDate = date;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

}
