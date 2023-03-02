package com.example.pidevthecreators.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String question;
    private String proposition1;
    private String proposition2;
    private String proposition3;
    private String reponse;

    @ManyToOne
    private EvaluationCustomer evaluationCustomer;


}
