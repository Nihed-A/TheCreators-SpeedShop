package com.example.pidevthecreators.services;

import com.example.pidevthecreators.entities.EvaluationCustomer;

import java.util.List;

public interface IEvaluationCustomerService {

    EvaluationCustomer addEvaluation(EvaluationCustomer evaluationCustomer) ;

    EvaluationCustomer updateEvaluation(EvaluationCustomer e);


    void RemoveEvaluation(long id);

    EvaluationCustomer findById(long id);

    List<EvaluationCustomer> findAllEvaluationCostumers();
}
