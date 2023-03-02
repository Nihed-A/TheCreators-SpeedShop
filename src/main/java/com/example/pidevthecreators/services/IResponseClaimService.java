package com.example.pidevthecreators.services;

import com.example.pidevthecreators.entities.ResponseClaim;

public interface IResponseClaimService {
    ResponseClaim createResponseClaim(ResponseClaim responseClaim);


    ResponseClaim updateResponseClaim(ResponseClaim responseClaim);

    void deleteResponseClaim(Integer idComment);

    ResponseClaim assignResponseClaimToRequestClaim(Integer idResponse, Integer idClaim);
}
