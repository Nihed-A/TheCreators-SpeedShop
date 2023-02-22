package com.example.pidevthecreators.repositories;

import com.example.pidevthecreators.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}