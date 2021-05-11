package com.example.fooddelivery.service;

import com.example.fooddelivery.dto.RestaurantDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//Service interface for Restaurant related operations.
public interface RestaurantService {

	Page<RestaurantDTO> getAllRestaurants(Pageable pageable);

}
