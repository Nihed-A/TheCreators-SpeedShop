package com.example.pidevthecreators.repositories;

import com.example.pidevthecreators.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Integer> {
}