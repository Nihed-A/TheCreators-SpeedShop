package com.example.pidevthecreators.services;

import com.example.pidevthecreators.entities.RequestClaim;
import com.example.pidevthecreators.entities.Status;
import com.example.pidevthecreators.entities.TypeClaim;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IRequestClaimService {
    RequestClaim addClaim(RequestClaim claim);

    RequestClaim updateClaim(RequestClaim claim);

    RequestClaim retrieveClaim(Integer idClaim);

    List<RequestClaim> retrieveAllClaims();

    void removeClaim(Integer idClaim);

    //Map<Status, Integer> countReclamationsByStatus();


    HashMap<String, Integer> Claimmax();

    public List<RequestClaim> findClaimsByType(TypeClaim typeClaim);

     void retrieveComplaintsINPROGRESS();



}
