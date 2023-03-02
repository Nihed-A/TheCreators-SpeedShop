package com.example.pidevthecreators.controllers;

import com.example.pidevthecreators.entities.EvaluationCustomer;
import com.example.pidevthecreators.services.IEvaluationCustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/EvaluationCustomer")
public class EvaluationCustomerController  {

    private final IEvaluationCustomerService evaluationCustomerService;

    @PostMapping("/add")
    @ResponseBody
    public EvaluationCustomer addEvaluation(@RequestBody EvaluationCustomer evaluationCustomer)
    {
        return evaluationCustomerService.addEvaluation(evaluationCustomer);
    }
    @PutMapping("/update")
    @ResponseBody
    public EvaluationCustomer updateEvaluation(@RequestBody EvaluationCustomer evaluationCustomer) {
        return evaluationCustomerService.updateEvaluation(evaluationCustomer);
    }

    @DeleteMapping("/remove/{id}")
    @ResponseBody
    public void removeEvaluation(@PathVariable("id") long id) {
        evaluationCustomerService.RemoveEvaluation(id);
    }

    @GetMapping("/retrieve-by-id/{id}")
    @ResponseBody
    public EvaluationCustomer retrieveById(@PathVariable("id") long id){
        return evaluationCustomerService.findById(id);
    }

    @GetMapping("/retrieve-all-EvaluationCustomer")
    @ResponseBody
    public List<EvaluationCustomer> getEvaluationCustomers() {
        return evaluationCustomerService.findAllEvaluationCostumers();
    }
}
