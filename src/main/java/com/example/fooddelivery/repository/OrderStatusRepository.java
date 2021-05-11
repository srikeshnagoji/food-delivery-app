package com.example.fooddelivery.repository;

import com.example.fooddelivery.model.OrderStatus;
import com.example.fooddelivery.model.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//Repository DAO class to perform CRUD on Order_status table.
@Repository
public interface OrderStatusRepository extends JpaRepository<OrderStatus,Long>, JpaSpecificationExecutor<OrderStatus> {
    List<OrderStatus> findAll();

    Optional<OrderStatus> findByOrderStatus(String orderStatus);

    Optional<OrderStatus> findByOrderStatusId(String orderStatusId);
}
