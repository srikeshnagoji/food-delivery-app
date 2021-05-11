package com.example.fooddelivery.controller;

import com.example.fooddelivery.dto.FoodDTO;
import com.example.fooddelivery.dto.OrdersDTO;
import com.example.fooddelivery.dto.RestaurantDTO;
import com.example.fooddelivery.service.FoodService;
import com.example.fooddelivery.service.OrdersService;
import com.example.fooddelivery.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Rest controller exposing various endpoints required by the UI for food delivery app.
 */
//NOTE: This can be segregated into different controllers based on the UI or the aspect.
@RestController
public class Controller {

	@Autowired
	private RestaurantService restaurantService;

	@Autowired
	private FoodService foodService;

	@Autowired
	private OrdersService ordersService;

	/**
	 * Endpoint that returns all the restaurants.
	 *
	 * @param pageable - Incoming pagination info
	 * @return page of restaurants.
	 */
	@GetMapping("/restaurants")
	public Page<RestaurantDTO> getAllRestaurants(Pageable pageable){
		return restaurantService.getAllRestaurants(pageable);
	}

	/**
	 * Endpoint that provides all the available foods based on a particular selected restaurant.
	 *
	 * @param restaurantId - Incoming restaurant ID selected by the user.
	 * @param pageable - pagination info request object.
	 * @return page of foods in the given restaurant.
	 */
	@GetMapping("/restaurant/{restaurantId}/food")
	public Page<FoodDTO> getAllFoodsByRestaurant(@PathVariable Long restaurantId, Pageable pageable){
		return foodService.getAllFoodsByRestaurant(restaurantId,pageable);
	}

	/**
	 * Endpoint to save new order into the DB.
	 *
	 * @param ordersDTO - new Order object received in the form of a DTO.
	 * @return - Saved object having the ID.
	 */
	@PostMapping("/orders/new")
	public OrdersDTO saveNewOrder(@RequestBody OrdersDTO ordersDTO){
		return ordersService.saveNewOrder(ordersDTO);
	}

	/**
	 * Endpoint to remove a dish from the restaurant menu by providing the food ID.
	 *
	 * @param id - ID of the food.
	 */
	@DeleteMapping("/food/remove/{id}")
	public void removeFoodById(@PathVariable Long id){
		foodService.removeFoodById(id);
	}

	/**
	 * Endpoint to update an order that was previously placed.
	 *
	 * @param id - order ID
	 * @param quantity - Number to be updated.
	 * @param userId - Logged in User ID
	 * @return - Success response to UI.
	 */
	@RequestMapping(value="/orders/update/quantity/{id}",method=RequestMethod.PUT)
	public ResponseEntity updateOrderQuantity(@PathVariable Long id, @RequestBody Long quantity, @RequestHeader(value="userId") Long userId){
		 ordersService.updateOrderQuantity(id,quantity,userId);
		 return new ResponseEntity(HttpStatus.OK);
	}


}
