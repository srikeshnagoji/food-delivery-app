package com.example.fooddelivery.service;

import com.example.fooddelivery.dto.FoodDTO;
import com.example.fooddelivery.dto.RestaurantDTO;
import com.example.fooddelivery.model.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

//Service interface for Food related operations.
public interface FoodService {

	public Page<FoodDTO> getAllFoodsByRestaurant(Long restaurantId, Pageable pageable);

    public void removeFoodById(Long id);
}
