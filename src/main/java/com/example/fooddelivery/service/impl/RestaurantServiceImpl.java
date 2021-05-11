package com.example.fooddelivery.service.impl;

import com.example.fooddelivery.dto.RestaurantDTO;
import com.example.fooddelivery.model.Restaurant;
import com.example.fooddelivery.repository.RestaurantRepository;
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
 * Service implementation for Restaurant related operations.
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Endpoint that returns all the restaurants.
	 *
	 * @param pageable - Incoming pagination info
	 * @return page of restaurants.
	 */
	@Override
	public Page<RestaurantDTO> getAllRestaurants(Pageable pageable) {
		Page<Restaurant> pageOfRestaurants = restaurantRepository.findAll(pageable);
		List<RestaurantDTO> listOfRestaurantDTOs = pageOfRestaurants.getContent().stream().map(entity -> modelMapper.map(entity, RestaurantDTO.class))
				.collect(Collectors.toList());
		return new PageImpl(listOfRestaurantDTOs, pageable, pageOfRestaurants.getTotalElements());
	}
}
