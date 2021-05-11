package com.example.fooddelivery.service.impl;

import com.example.fooddelivery.dto.OrdersDTO;
import com.example.fooddelivery.exception.NotFoundException;
import com.example.fooddelivery.exception.ValidationException;
import com.example.fooddelivery.model.Order;
import com.example.fooddelivery.repository.OrdersRepository;
import com.example.fooddelivery.service.OrdersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service implementation for Order related operations.
 */
@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersRepository ordersRepository;

	@Autowired
	private ModelMapper modelMapper;


	/**
	 * Endpoint to save new order into the DB.
	 *
	 * @param ordersDTO - new Order object received in the form of a DTO.
	 * @return - Saved object having the ID.
	 */
	@Override
	public OrdersDTO saveNewOrder(OrdersDTO ordersDTO) {
		Order savedOrder = ordersRepository.save(modelMapper.map(ordersDTO, Order.class));
		return modelMapper.map(savedOrder, OrdersDTO.class);
	}

	/**
	 * Endpoint to update an order that was previously placed.
	 *
	 * @param id - order ID
	 * @param quantity - Number to be updated.
	 * @param userId - Logged in User ID
	 * @return - Success response to UI.
	 */
	@Override
	public void updateOrderQuantity(Long id, Long quantity, Long userId) {
		Optional<Order> order = ordersRepository.findById(id);
		if(order.isPresent()){
			if( order.get().getUser().getId()==userId) {
				Order entity = order.get();
				entity.setQuantity(quantity);
				ordersRepository.save(entity);
			}else{
				//add a logger here
				throw new ValidationException("User not allowed to modify this order",
						"The order does not belong to this user",
						"Provide the order ID belonging to the logged in user");
			}
		}else{
			//Add a logger here
			throw new NotFoundException("Order does not exist", "Invalid order ID given", "Verify the order ID/user ID");
		}

	}
}
