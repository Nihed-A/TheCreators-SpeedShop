package com.example.pidevthecreators.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @NotBlank(message = "The username is required")
    private String username;
    String name;
    @NotBlank(message = "The password is required")
    String password;
    String mail;
    Date dateOfBirth;
    String address;
    String image;
    String numTel;
    @Enumerated(EnumType.STRING)
    Role role;
    @OneToMany(mappedBy = "user",cascade = {CascadeType.PERSIST})
    List<Order> orders;
    @OneToMany(mappedBy = "user",cascade = {CascadeType.PERSIST})
    List<Product>products;
    @OneToMany(mappedBy = "user",cascade = {CascadeType.PERSIST})
    List<Location>locations;
    @OneToMany(mappedBy = "user",cascade = {CascadeType.PERSIST})
    List<Tender>tenders;
    @OneToMany(mappedBy = "user",cascade = {CascadeType.PERSIST})
    List<RequestClaim>requestClaims;
    @OneToOne(mappedBy = "user",cascade = {CascadeType.PERSIST})
    EvaluationCustomer evaluationCustomer;

}
