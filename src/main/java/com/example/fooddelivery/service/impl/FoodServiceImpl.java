package com.example.fooddelivery.service.impl;

import com.example.fooddelivery.dto.FoodDTO;
import com.example.fooddelivery.dto.RestaurantDTO;
import com.example.fooddelivery.model.Food;
import com.example.fooddelivery.model.Restaurant;
import com.example.fooddelivery.repository.FoodRepository;
import com.example.fooddelivery.repository.RestaurantRepository;
import com.example.fooddelivery.service.FoodService;
import com.example.fooddelivery.service.RestaurantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for food related operations.
 */
@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodRepository foodRepository;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Service to fetch all the food available in the restaurant.
	 *
	 * @param restaurantId - ID of the restaurant that is selected.
	 * @param pageable - pagination request from UI.
	 * @return - paginated response of Food.
	 */
	@Override
	public Page<FoodDTO> getAllFoodsByRestaurant(Long restaurantId, Pageable pageable) {
		Page<Food> pageOfFoods = foodRepository.findByRestaurant_RestaurantId(restaurantId,pageable);
		List<FoodDTO> listOfFoodDTOs = pageOfFoods.getContent().stream().map(entity -> modelMapper.map(entity, FoodDTO.class))
				.collect(Collectors.toList());
		return new PageImpl(listOfFoodDTOs, pageable, pageOfFoods.getTotalElements());
	}

	/**
	 * Service to remove the a particular food by its ID.
	 * NOTE: This needs to have validation that only ADMIN can do this operation.
	 *
	 * @param id - ID of the food
	 */
	@Override
	public void removeFoodById(Long id) {
		foodRepository.deleteById(id);
	}
}
