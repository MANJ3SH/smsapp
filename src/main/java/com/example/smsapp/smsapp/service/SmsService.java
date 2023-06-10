package com.example.smsapp.smsapp.service;



import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    @Value("${twilio.accountSid}")
    private String accountSid;

    @Value("${twilio.authToken}")
    private String authToken;

    @Value("${twilio.phoneNumber}")
    private String phoneNumber;

    public void sendSms(String recipientPhoneNumber, String message) {
        Twilio.init(accountSid, authToken);

        try {
            Message.creator(
                    new PhoneNumber(recipientPhoneNumber),
                    new PhoneNumber(phoneNumber),
                    message
            ).create();
        } catch (ApiException e) {
            // Handle any exceptions or errors
            e.printStackTrace();
        }
    }
}
