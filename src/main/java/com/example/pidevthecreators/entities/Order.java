package com.example.pidevthecreators.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idOrder;
    Date datCmd;
    String code;
    @OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST})
    List<Product>products;
    @OneToOne(mappedBy = "order", cascade = {CascadeType.PERSIST})
    Bill bill;
    @ManyToOne
    AppUser user;
    @OneToOne(mappedBy = "order", cascade = {CascadeType.PERSIST})
    Delivery delivery;
    @OneToOne(mappedBy = "order", cascade = {CascadeType.PERSIST})
    OrderReturn orderReturn;
    @OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST})
    List<RequestClaim>requestClaims;


}
