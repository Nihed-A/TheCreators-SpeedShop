package com.example.pidevthecreators.repositories;

import com.example.pidevthecreators.entities.RequestClaim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestClaimRepository extends JpaRepository<RequestClaim, Integer> {
}