package com.example.pidevthecreators.repositories;

import com.example.pidevthecreators.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}