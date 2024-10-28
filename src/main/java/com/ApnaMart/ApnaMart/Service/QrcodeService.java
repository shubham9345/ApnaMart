package com.ApnaMart.ApnaMart.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

@Service
public class QrcodeService {

    /**
     * Generates a QR code image with a watermark as a byte array.
     *
     * @param text The text or URL that the QR code will represent.
     * @param width The width of the QR code image.
     * @param height The height of the QR code image.
     * @param watermarkText The text to add as a watermark.
     * @return A byte array representing the QR code image with a watermark.
     * @throws WriterException If there is an error generating the QR code.
     * @throws IOException If there is an error writing the QR code image.
     */
    public byte[] generateQRCodeWithWatermark(String text, int width, int height, String watermarkText) throws WriterException, IOException {
        // Step 1: Generate the QR code
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
        BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

        // Step 2: Create a new BufferedImage to add the watermark
        BufferedImage combinedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = combinedImage.createGraphics();

        // Draw the QR code onto the new BufferedImage
        graphics.drawImage(qrImage, 0, 0, null);

        // Set font and color for watermark
        Font font = new Font("Sans-Serif", Font.BOLD, 25);
        graphics.setFont(font);
        graphics.setColor(new Color(135, 206, 235, 242));  // skyblue color with transparency

        // Calculate the position for the watermark text (centered at the bottom)
        FontMetrics fontMetrics = graphics.getFontMetrics();
//        int x = (width - fontMetrics.stringWidth(watermarkText)) / 2;
//        int y = height - fontMetrics.getHeight() + 35;  // Adjust as needed
        int x = (width - fontMetrics.stringWidth(watermarkText)) / 2;
        int y = (height - fontMetrics.getHeight()) / 2 + fontMetrics.getAscent();

        // Draw the watermark text onto the combined image
        graphics.drawString(watermarkText, x, y);
        graphics.dispose();  // Always dispose of the Graphics2D context

        // Convert the combined image with the watermark to a byte array
        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        ImageIO.write(combinedImage, "PNG", pngOutputStream);
        return pngOutputStream.toByteArray();
    }
}
