package com.example.fooddelivery.service;

import com.example.fooddelivery.dto.OrdersDTO;
import com.example.fooddelivery.dto.RestaurantDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//Service interface for Order related operations.
public interface OrdersService {

	OrdersDTO saveNewOrder(OrdersDTO ordersDTO);

    void updateOrderQuantity(Long id, Long quantity, Long userId);
}
