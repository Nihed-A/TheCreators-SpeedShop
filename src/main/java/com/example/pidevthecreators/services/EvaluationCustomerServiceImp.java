package com.example.pidevthecreators.services;

import com.example.pidevthecreators.entities.EvaluationCustomer;
import com.example.pidevthecreators.entities.Question;
import com.example.pidevthecreators.repositories.EvaluationCustomerRepository;
import com.example.pidevthecreators.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service


public class EvaluationCustomerServiceImp implements IEvaluationCustomerService {

   @Autowired
    EvaluationCustomerRepository evaluationCustomerRepository;


     @Autowired
    QuestionRepository questionRepo;

    @Override
    @Transactional
    public EvaluationCustomer addEvaluation(EvaluationCustomer evaluationCustomer) {
        List<Question> questions = new ArrayList<>();
        evaluationCustomer.getQuestions();
        for (Question question : questions) {
            question.setEvaluationCustomer(evaluationCustomer);
            questionRepo.save(question);
        }
        return evaluationCustomerRepository.save(evaluationCustomer);
    }



    @Override
    public EvaluationCustomer updateEvaluation(EvaluationCustomer evaluationCustomer) {
        List<Question> questions = new ArrayList<>();
        evaluationCustomer.getQuestions();
        for (Question question : questions) {
            question.setEvaluationCustomer(evaluationCustomer);
            questionRepo.save(question);
        }
        return evaluationCustomerRepository.save(evaluationCustomer);
    }

    @Override
    public void RemoveEvaluation(long id) {
        EvaluationCustomer evaluationCustomer = evaluationCustomerRepository.findById(id).orElse(null);
        List<Question> questions = evaluationCustomer.getQuestions();
        evaluationCustomerRepository.deleteAll();
        evaluationCustomerRepository.deleteById(id);
    }



    @Override
    public EvaluationCustomer findById(long id) {
        return evaluationCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public List<EvaluationCustomer> findAllEvaluationCostumers() {
        return (List<EvaluationCustomer>) evaluationCustomerRepository.findAll();
    }

}
