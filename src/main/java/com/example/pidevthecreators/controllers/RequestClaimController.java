package com.example.pidevthecreators.controllers;

import com.example.pidevthecreators.entities.RequestClaim;
import com.example.pidevthecreators.entities.Status;
import com.example.pidevthecreators.entities.TypeClaim;
import com.example.pidevthecreators.services.IRequestClaimService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@RequestMapping("/RequestClaim")
public class RequestClaimController {
    private final IRequestClaimService RequestClaimService;

    @PostMapping("/addClaim")
    public RequestClaim addClaim(@RequestBody RequestClaim claim) {
        return RequestClaimService.addClaim(claim);
    }

    @PutMapping("/UpdateClaim")
    RequestClaim updateClaim(@RequestBody RequestClaim claim) {
        return RequestClaimService.updateClaim(claim);
    }

    @GetMapping("/get/{idClaim}")
    RequestClaim retrieveClaim(@PathVariable("idClaim") Integer idClaim) {
        return RequestClaimService.retrieveClaim(idClaim);
    }

    @GetMapping("/all")
    public List<RequestClaim> retrieveAllClaims() {
        return RequestClaimService.retrieveAllClaims();
    }

    @DeleteMapping("/deleteClaim/{idClaim}")
    void removeClaim(@PathVariable("idClaim") Integer idClaim) {
        RequestClaimService.removeClaim(idClaim);
    }


    // méthode qui calcule le nombre de réclamations validées et en cours dans un système de gestion de réclamations.
  /*  @GetMapping("/stat")

    public Map<Status, Integer> countReclamationsByStatus () {

       return  RequestClaimService.countReclamationsByStatus();
    }*/

    // méthode qui calcule le nombre de réclamations validées et en cours dans un système de gestion de réclamations.
    @GetMapping("/stat")
    @ResponseBody
    public HashMap<String, Integer> statistique() {
        return RequestClaimService.Claimmax();
    }


      @GetMapping("/RechercheClaimParType/")
        public List<RequestClaim> findClaimsByType(@RequestParam ("typeClaim") TypeClaim typeClaim){
        return RequestClaimService.findClaimsByType(typeClaim);
        }

}
