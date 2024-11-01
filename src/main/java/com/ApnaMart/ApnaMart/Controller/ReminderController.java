package com.ApnaMart.ApnaMart.Controller;

import com.ApnaMart.ApnaMart.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ReminderController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendReminder")
    public String sendReminder(
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String message) {
        emailService.sendReminderEmail(to, subject, message);
        return "Reminder email sent successfully!";
    }
}