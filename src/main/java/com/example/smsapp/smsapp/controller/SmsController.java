package com.example.smsapp.smsapp.controller;




import com.example.smsapp.smsapp.payload.SmsRequest;
import com.example.smsapp.smsapp.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsController {

    private final SmsService smsService;

    @Autowired
    public SmsController(SmsService smsService) {
        this.smsService = smsService;
    }

    //http://localhost:8080/sms/send
    @PostMapping("/sms/send")
    public void sendSms(@RequestBody SmsRequest smsRequest) {
        smsService.sendSms(smsRequest.getRecipientPhoneNumber(), smsRequest.getMessage());
    }
}
