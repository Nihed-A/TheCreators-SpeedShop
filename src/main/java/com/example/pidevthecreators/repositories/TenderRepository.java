package com.example.pidevthecreators.repositories;

import com.example.pidevthecreators.entities.Tender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenderRepository extends JpaRepository<Tender, Integer> {
}