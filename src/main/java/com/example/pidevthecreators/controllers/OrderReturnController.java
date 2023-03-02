package com.example.pidevthecreators.controllers;

import com.example.pidevthecreators.entities.OrderReturn;
import com.example.pidevthecreators.services.OrderReturnService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@AllArgsConstructor
@RestController
@RequestMapping("/OrderReturn")
public class OrderReturnController {

    private final OrderReturnService orderReturnService;



    @PostMapping
    public OrderReturn saveFacture(@RequestBody OrderReturn orderReturn){
        return orderReturnService.saveFacture(orderReturn);
    }
  
}
