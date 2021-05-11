package com.example.fooddelivery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//Entity class that maps on to DB table.
@Entity
@Table(name= "ORDERS")
public class Order {

	@Id @GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name = "ID")
	private Long id;
	@JoinColumn(name = "FOOD_ID")
	@ManyToOne
	private Food food;
	@Column(name="QUANTITY")
	private Long quantity;
	@JoinColumn(name = "USER_ID")
	@ManyToOne
	private User user;
	@JoinColumn(name = "RESTAURANT_ID")
	@ManyToOne
	private Restaurant restaurant;
	@JoinColumn(name = "ORDER_STATUS_ID")
	@ManyToOne
	private OrderStatus orderStatus;

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Order() {
	}

	public Order(Food food, Long quantity, User user, Restaurant restaurant, OrderStatus orderStatus) {
		this.food = food;
		this.quantity = quantity;
		this.user = user;
		this.restaurant = restaurant;
		this.orderStatus = orderStatus;
	}
}
