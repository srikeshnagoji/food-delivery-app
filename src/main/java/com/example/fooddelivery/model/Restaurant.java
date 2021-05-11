package com.example.fooddelivery.model;

import javax.persistence.*;
//Entity class that maps on to DB table.
@Entity
@Table(name= "RESTAURANT")
public class Restaurant {
	@Id @GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name = "RESTAURANT_ID")
	private Long restaurantId;
	@Column(name = "NAME")
	private String name;

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Restaurant(String name) {
		this.name = name;
	}

	public Restaurant() {
	}
}
