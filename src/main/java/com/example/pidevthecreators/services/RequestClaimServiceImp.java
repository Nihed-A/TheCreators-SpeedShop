package com.example.pidevthecreators.services;


import com.example.pidevthecreators.entities.RequestClaim;
//import com.example.pidevthecreators.entities.SmsRequest;
import com.example.pidevthecreators.entities.SmsRequest;
import com.example.pidevthecreators.entities.Status;
import com.example.pidevthecreators.entities.TypeClaim;
import com.example.pidevthecreators.repositories.RequestClaimRepository;
import com.example.pidevthecreators.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class RequestClaimServiceImp implements IRequestClaimService {

    private final RequestClaimRepository requestClaimRepository;
    private final SmsService smsService;

    private final UserRepository userRepository;

    private static final int maxAlerts = 2;
    private final String[] badwords = {"bitch", "ass", "asshole", "cunt", "dick", "shit", "fuck"};

    @Override
    public RequestClaim addClaim(RequestClaim claim) {
        log.info("Saving New Claim: {}", claim.getTypeClaim());
        return requestClaimRepository.save(claim);
    }


    @Override
    public RequestClaim updateClaim(RequestClaim claim) {
        return requestClaimRepository.save(claim);
    }

    public RequestClaim retrieveClaim(Integer idClaim) {

        return requestClaimRepository.findById(idClaim).orElse(null);
    }

    public List<RequestClaim> retrieveAllClaims() {
        return requestClaimRepository.findAll();
    }

    @Override
    public void removeClaim(Integer idClaim) {
        requestClaimRepository.deleteById(idClaim);
    }


    public Map<Status, Integer> countReclamationsByStatus() {
        return null;
    }


    //méthode qui calcule le nombre de réclamations validées et en cours dans un système de gestion de réclamations.

    public HashMap<String, Integer> Claimmax() {
        int pending = 0;
        int inprogress = 0;
        int resolved = 0;
        int refused = 0;
        int nbr_claim = 0;

        for (RequestClaim r : requestClaimRepository.findAll()) {
            if (r.getStatus().toString().equals("resolved"))
                resolved = resolved + 1;

            else if (r.getStatus().toString().equals("refused")) {
                refused = refused + 1;
            } else if (r.getStatus().toString().equals("pending")) {
                pending = pending + 1;
            } else if (r.getStatus().toString().equals("inprogress")) {
                inprogress = inprogress + 1;
            }

        }


        nbr_claim = inprogress + pending + resolved + refused;
        HashMap<String, Integer> statique = new HashMap<String, Integer>();
        statique.put("reclamation resolved", resolved);
        statique.put("reclamation  in progress", inprogress);
        statique.put("reclamation  in pending", pending);
        statique.put("reclamation  in refused", refused);


        return statique;


    }




    /*@Override
    public Map<Status, Integer> countReclamationsByStatus() {
        Map<Status, Integer> counts = new HashMap<>();
        for (Status status : Status.values()) {
            counts.put(status, requestClaimRepository.findByStatus(status).size());


        }
        return counts;


    }*/

    @Override
    public List<RequestClaim> findClaimsByType(TypeClaim typeClaim) {
        List<RequestClaim> allClaims = requestClaimRepository.findAll();
        List<RequestClaim> target = new ArrayList<RequestClaim>();
        for (RequestClaim claim : allClaims) {
            if (claim.getTypeClaim().equals(typeClaim)) {
                target.add(claim);
            }
        }
        return target;
    }

   @Scheduled(fixedDelay = 60000)
    public void badwordsFilter() {
        boolean hasBadWords = false;
        System.out.println("In method Bad Words Filter ....");
        List<RequestClaim> requestClaims = requestClaimRepository.findAll();
        for (RequestClaim requestClaim : requestClaims) {
            List<String> description = new ArrayList<String>(Arrays.asList(requestClaim.getSummary().split(" ")));
            List<String> finalString = new ArrayList<String>();
            for (String word : description) {
                for (String badword : badwords) {
                    if (word.matches(".*" + badword + ".*")) {
                        hasBadWords = true;
                        word = "****";
                    }
                }
                finalString.add(word);
            }
            requestClaim.setSummary(String.join(" ", finalString));

            if (hasBadWords) {
                if (requestClaim.getUser().getNumberOfAlerts() < maxAlerts ) {
                    requestClaim.getUser().setNumberOfAlerts(requestClaim.getUser().getNumberOfAlerts() + 1);
                    SmsRequest smsAlert = new SmsRequest(requestClaim.getUser().getNumTel(),requestClaim.getUser().getName() + ", This sms is a warning for you not meeting the appropriate behaviour" +
                            " inside the app. Your recent post had offensive words. A matter that we condemn in the strongest of possible terms. We hope this act never repeats itself otherwise we will be in the obligation of taking punitive measures against you\"");
                    smsService.sendSms(smsAlert);
                    hasBadWords = false;
                } else {
                    requestClaim.getUser().setEnabled(false);
                }

            }
        }
    }

    @Scheduled(cron = "0 0 8 * * MON,WED")
    public void retrieveComplaintsINPROGRESS() {
        List<RequestClaim> requestClaims = this.requestClaimRepository.findByStatus(Status.inprogress);
        for(RequestClaim c : requestClaims){
            if (c.getDateCreation().before(new Date())) {
                log.info("List of pending claims: " + c.getSummary() +
                        " : Customer : " + c.getUser().getName() +
                        " : Created-At : " + c.getDateCreation());
            }
        }

    }
}

