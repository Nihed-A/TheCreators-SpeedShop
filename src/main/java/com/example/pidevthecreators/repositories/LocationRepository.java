package com.example.pidevthecreators.repositories;

import com.example.pidevthecreators.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}