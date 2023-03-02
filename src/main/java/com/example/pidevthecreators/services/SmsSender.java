package com.example.pidevthecreators.services;


import com.example.pidevthecreators.entities.SmsRequest;

public interface SmsSender {
    void sendSms(SmsRequest smsRequest);
}
