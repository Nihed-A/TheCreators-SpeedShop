package com.example.pidevthecreators.services;

import com.example.pidevthecreators.entities.OrderReturn;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

public interface IOrderReturnService {


    OrderReturn saveFacture(OrderReturn commande);
}
