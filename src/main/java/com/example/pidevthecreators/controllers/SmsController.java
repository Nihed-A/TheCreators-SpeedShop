package com.example.pidevthecreators.controllers;

import com.example.pidevthecreators.entities.SatisfactoryStatus;
import com.example.pidevthecreators.entities.SmsRequest;
import com.example.pidevthecreators.services.SmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/sms)")
public class SmsController {


    private final SmsService smsService;


    public void sendSms(@RequestBody SmsRequest smsRequest){

        smsService.sendSms(smsRequest);
    }
}
