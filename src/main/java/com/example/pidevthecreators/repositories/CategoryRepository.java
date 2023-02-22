package com.example.pidevthecreators.repositories;

import com.example.pidevthecreators.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}