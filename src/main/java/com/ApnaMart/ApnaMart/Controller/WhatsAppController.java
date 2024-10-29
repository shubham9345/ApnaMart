package com.ApnaMart.ApnaMart.Controller;


import com.ApnaMart.ApnaMart.Service.WhatsAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WhatsAppController {

    @Autowired
    private WhatsAppService whatsAppService;

    @PostMapping("/sendWhatsApp")
    public String sendWhatsApp(
            @RequestParam String to,
            @RequestParam String message) {
        return whatsAppService.sendWhatsAppMessage(to, message);
    }
}
