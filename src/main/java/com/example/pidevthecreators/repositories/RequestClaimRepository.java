package com.example.pidevthecreators.repositories;

import com.example.pidevthecreators.entities.RequestClaim;
import com.example.pidevthecreators.entities.Status;
import com.example.pidevthecreators.entities.TypeClaim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RequestClaimRepository extends JpaRepository<RequestClaim, Integer> {

    public List<RequestClaim> findRequestClaimByTypeClaim(TypeClaim typeClaim);
   //  RequestClaim findByStatus(Status status);
    RequestClaim findByRef(int ref);

    List<RequestClaim> findByStatus(Status inprogress);
    //RequestClaim findByClientRequester(String ClientRequester );
}