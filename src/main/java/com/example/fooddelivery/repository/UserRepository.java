package com.example.fooddelivery.repository;

import com.example.fooddelivery.model.Restaurant;
import com.example.fooddelivery.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Repository DAO class to perform CRUD on User table.
@Repository
public interface UserRepository extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {
    Optional<User> findById(Long userId);
}
