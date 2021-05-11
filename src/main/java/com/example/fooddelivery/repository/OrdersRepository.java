package com.example.fooddelivery.repository;

import com.example.fooddelivery.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

//Repository DAO class to perform CRUD on ORDER table.
@Repository
public interface OrdersRepository extends JpaRepository<Order,Long>, JpaSpecificationExecutor<Order> {

}
