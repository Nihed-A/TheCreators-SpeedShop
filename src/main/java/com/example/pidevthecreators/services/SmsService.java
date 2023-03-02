package com.example.pidevthecreators.services;


import com.example.pidevthecreators.entities.SmsRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SmsService {
    private final SmsSender smsSender ;

   @Autowired
    public SmsService(@Qualifier("twilio") TwilioSmsSender smsSender){
        this.smsSender = smsSender;
    }
    public void sendSms(SmsRequest smsRequest ) {

        smsSender.sendSms(smsRequest);
    }
}
