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
public class EvaluationCustomer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nameClient;
    @Enumerated(EnumType.STRING)
    SatisfactoryStatus satisfactoryStatus;
    String description;
    @OneToOne
    AppUser user;

    @OneToMany(mappedBy = "evaluationCustomer", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Question> questions;

}
