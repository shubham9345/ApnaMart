package com.ApnaMart.ApnaMart.Service;

import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.twilio.type.PhoneNumber;

@Service
public class WhatsAppService {

    @Value("${twilio.whatsapp.number}")
    private String twilioWhatsAppNumber;

    public String sendWhatsAppMessage(String to, String message) {
        try {
            Message.creator(
                            new PhoneNumber("whatsapp:" + to),  // To WhatsApp number
                            new PhoneNumber(twilioWhatsAppNumber),  // From Twilio WhatsApp number
                            message)
                    .create();

            return "WhatsApp message sent successfully!";
        } catch (Exception e) {
            return "Failed to send WhatsApp message: " + e.getMessage();
        }
    }
}
