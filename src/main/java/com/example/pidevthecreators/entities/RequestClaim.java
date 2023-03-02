package com.example.pidevthecreators.entities;


import lombok.*;
import net.bytebuddy.description.type.TypeDescription;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Data
public class RequestClaim implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idClaim;
    @Enumerated(EnumType.STRING)
    TypeClaim typeClaim;
    @Column(unique = true)
    int ref;
    Date dateCreation;
    String Summary;
    @Enumerated(EnumType.STRING)
    Status status;
 
    String ClientRequester;
    @ManyToOne
    Order order;
    @OneToMany(mappedBy = "requestClaim",cascade = {CascadeType.PERSIST})
    List<ResponseClaim>responseClaims;
    @ManyToOne
    AppUser user;



}
