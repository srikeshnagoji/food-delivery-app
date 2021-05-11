package com.example.fooddelivery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//Entity class that maps on to DB table.
@Entity
@Table(name= "ORDER_STATUS")
public class OrderStatus {

	@Id @GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name = "ORDER_STATUS_ID")
	private Long orderStatusId;
	@Column(name = "ORDER_STATUS")
	private String orderStatus;

	public Long getOrderStatusId() {
		return orderStatusId;
	}

	public void setOrderStatusId(Long orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public OrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public OrderStatus() {
	}
}

