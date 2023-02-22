package com.example.pidevthecreators.repositories;

import com.example.pidevthecreators.entities.OrderReturn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderReturnRepository extends JpaRepository<OrderReturn, Integer> {
}