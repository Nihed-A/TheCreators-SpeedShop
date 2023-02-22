package com.example.pidevthecreators.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderReturn implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    Date dateofState;
    String description;
    int quntity;
    String unity;
    String ht;
    String tva;
    String totalttc;
    @OneToOne
    Order order;
}
