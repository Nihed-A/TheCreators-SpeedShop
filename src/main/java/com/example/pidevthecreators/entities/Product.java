package com.example.pidevthecreators.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    float price;
    String image;
    String description;
    String Brand;
    @ManyToOne
    Order order;
    @ManyToOne
    Category category;
    @ManyToOne
    Stock stock;
    @ManyToOne
    AppUser user;

}
