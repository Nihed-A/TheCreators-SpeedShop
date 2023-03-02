package com.example.pidevthecreators.services;

import com.example.pidevthecreators.entities.RequestClaim;
import com.example.pidevthecreators.entities.ResponseClaim;
import com.example.pidevthecreators.repositories.RequestClaimRepository;
import com.example.pidevthecreators.repositories.ResponseClaimRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ResponseClaimServiceImp implements IResponseClaimService{
    private final RequestClaimRepository requestClaimRepository;

    private final ResponseClaimRepository responseClaimRepository;

    @Override
    public ResponseClaim createResponseClaim(ResponseClaim responseClaim){
        return responseClaimRepository.save(responseClaim);
    }

    @Override
    public ResponseClaim updateResponseClaim(ResponseClaim responseClaim) {
        return  responseClaimRepository.save(responseClaim);
    }

    @Override
    public void deleteResponseClaim(Integer idComment)
        {
            responseClaimRepository.deleteById(idComment);
        }


    public List<ResponseClaim> getAllResponseClaim() {
        return responseClaimRepository.findAll();
    }



    public ResponseClaim assignResponseClaimToRequestClaim(Integer idResponse, Integer idClaim) {

        ResponseClaim e = responseClaimRepository.findById(idResponse).orElse(null);
        RequestClaim d = requestClaimRepository.findById(idClaim).orElse(null);

        e.setRequestClaim(d);
        return responseClaimRepository.save(e);
    }





}
