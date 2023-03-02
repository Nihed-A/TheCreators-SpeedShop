package com.example.pidevthecreators.services;

import com.example.pidevthecreators.entities.OrderReturn;
import com.example.pidevthecreators.repositories.OrderRepository;
import com.example.pidevthecreators.repositories.OrderReturnRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class OrderReturnService implements IOrderReturnService{


    private final OrderReturnRepository fctRep;
    private final OrderRepository orderRepository;


    @Override
    public OrderReturn saveFacture(OrderReturn orderReturn) {
        return fctRep.save(orderReturn);
    }





}
