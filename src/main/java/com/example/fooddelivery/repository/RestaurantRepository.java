package com.example.fooddelivery.repository;

import com.example.fooddelivery.model.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Repository DAO class to perform CRUD on Restaurant table.
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long>, JpaSpecificationExecutor<Restaurant> {
    Page<Restaurant> findAll(Pageable pageable);

    Optional<Restaurant> findByName(String name);
}
