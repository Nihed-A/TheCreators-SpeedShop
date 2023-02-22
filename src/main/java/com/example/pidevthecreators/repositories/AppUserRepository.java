package com.example.pidevthecreators.repositories;

import com.example.pidevthecreators.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
}