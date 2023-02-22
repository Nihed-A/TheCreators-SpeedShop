package com.example.pidevthecreators.repositories;

import com.example.pidevthecreators.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {
}