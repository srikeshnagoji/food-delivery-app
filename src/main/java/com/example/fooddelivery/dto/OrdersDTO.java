package com.example.fooddelivery.dto;

import com.example.fooddelivery.model.Food;
import com.example.fooddelivery.model.OrderStatus;
import com.example.fooddelivery.model.Restaurant;
import com.example.fooddelivery.model.User;

import javax.persistence.*;

// DTO for Order entity
public class OrdersDTO {


	private Long id;

	private Food food;

	private Long quantity;

	private User user;

	private Restaurant restaurant;

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

	public OrdersDTO() {
	}

	public OrdersDTO(Food food, Long quantity, User user, Restaurant restaurant, OrderStatus orderStatus) {
		this.food = food;
		this.quantity = quantity;
		this.user = user;
		this.restaurant = restaurant;
		this.orderStatus = orderStatus;
	}
}
