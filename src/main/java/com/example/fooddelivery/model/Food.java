package com.example.fooddelivery.model;

import javax.persistence.*;
//Entity class that maps on to DB table.
@Entity
@Table(name= "FOOD")
public class Food {
	@Id @GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name = "FOOD_ID")
	private Long foodId;
	@Column(name = "NAME")
	private String name;
	@JoinColumn(name = "RESTAURANT_ID")
	@ManyToOne
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

	public Food(String name,Restaurant restaurant) {
		this.name = name;
		this.restaurant=restaurant;
	}

	public Food() {
	}
}
