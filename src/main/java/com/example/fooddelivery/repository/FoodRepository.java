package com.example.fooddelivery.repository;

import com.example.fooddelivery.model.Food;
import com.example.fooddelivery.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

//Repository DAO class to perform CRUD on FOOD table.
@Repository
public interface FoodRepository extends JpaRepository<Food,Long>, JpaSpecificationExecutor<Food> {
    Page<Food> findAllByFoodId(Long id,Pageable pageable);

    Page<Food> findByRestaurant_RestaurantId(Long restaurantId,Pageable pageable);
}
