package com.example.pidevthecreators.repositories;

import com.example.pidevthecreators.entities.EvaluationCustomer;
import com.example.pidevthecreators.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluationCustomerRepository extends JpaRepository<EvaluationCustomer, Long> {

}