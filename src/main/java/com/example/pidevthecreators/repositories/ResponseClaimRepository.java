package com.example.pidevthecreators.repositories;

import com.example.pidevthecreators.entities.ResponseClaim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseClaimRepository extends JpaRepository<ResponseClaim, Integer> {
}