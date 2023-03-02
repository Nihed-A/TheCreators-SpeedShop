package com.example.pidevthecreators.controllers;

import com.example.pidevthecreators.entities.ResponseClaim;
import com.example.pidevthecreators.services.IResponseClaimService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/responseClaim")
public class ResponseClaimController {

    private final IResponseClaimService responseClaimService;

    @PostMapping
    public ResponseClaim createResponseClaim(@RequestBody ResponseClaim responseClaim){
        return responseClaimService.createResponseClaim(responseClaim);
    }

    @PutMapping
    public ResponseClaim updateResponseClaim(@RequestBody ResponseClaim responseClaim){
        return responseClaimService.updateResponseClaim(responseClaim);
    }

    @DeleteMapping("/{idComment}")
    void deleteResponseClaim(@PathVariable("idComment") Integer idComment){
        responseClaimService.deleteResponseClaim(idComment);
    }


    @PutMapping("assign/{idResponse}/{idClaim}")
    public void assignResponseClaimToRequestClaim(@PathVariable("idResponse") Integer idResponse, @PathVariable("idClaim") Integer idClaim) {
        responseClaimService.assignResponseClaimToRequestClaim(idResponse,idClaim);
    }





}
