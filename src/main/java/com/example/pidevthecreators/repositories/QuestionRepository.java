package com.example.pidevthecreators.repositories;

import com.example.pidevthecreators.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}