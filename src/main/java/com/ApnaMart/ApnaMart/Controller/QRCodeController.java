package com.ApnaMart.ApnaMart.Controller;


import com.ApnaMart.ApnaMart.Service.QrcodeService;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
@RestController
@RequestMapping("/api/qrcode")
public class QRCodeController {

    @Autowired
    private QrcodeService qrCodeGeneratorService;

    @GetMapping(value = "/generate-with-watermark", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> generateQRCodeWithWatermark(@RequestParam String text, @RequestParam String watermark) {
        try {
            int width = 250;
            int height = 250;
            byte[] qrCodeImage = qrCodeGeneratorService.generateQRCodeWithWatermark(text, width, height, watermark);
            return ResponseEntity.ok(qrCodeImage);
        } catch (WriterException | IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}

