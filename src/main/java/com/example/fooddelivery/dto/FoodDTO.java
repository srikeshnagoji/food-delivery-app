package com.example.fooddelivery.dto;

import com.example.fooddelivery.model.Restaurant;

import javax.persistence.*;

// DTO for Food entity
public class FoodDTO {

	private Long foodId;

	private String name;

	private Restaurant restaurant;

	public Long getFoodId() {
		return foodId;
	}

	public void setFoodId(Long foodId) {
		this.foodId = foodId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FoodDTO(String name, Restaurant restaurant) {
		this.name = name;
		this.restaurant=restaurant;
	}

	public FoodDTO() {
	}
}
