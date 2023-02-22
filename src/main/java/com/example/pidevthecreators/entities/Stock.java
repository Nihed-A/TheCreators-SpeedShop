package com.example.pidevthecreators.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Stock implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    float price;
    String image;
    String description;
    float quantity;
    @Enumerated(EnumType.STRING)
    TypeMvStock typeMvStock;
    @OneToMany(mappedBy = "stock",cascade = {CascadeType.PERSIST})
    List<Product>products;
}
