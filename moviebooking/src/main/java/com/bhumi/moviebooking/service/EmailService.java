package com.bhumi.moviebooking.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendTicketEmail(String toEmail, String userName, String movie, String seat) {

        try {

            System.out.println("🚀 Preparing email...");

            MimeMessage message = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            // ❗ VERY IMPORTANT (ADD THIS)
            helper.setFrom("YOUR_EMAIL@gmail.com"); // ⚠️ replace with your Gmail

            helper.setTo(toEmail);
            helper.setSubject("🎬 Ticket Booking Confirmed");

            String htmlContent = """
                    <html>
                        <body style="font-family: Arial; background-color: #f4f4f4; padding: 20px;">
                            
                            <div style="background-color: white; padding: 20px; border-radius: 10px;">
                                
                                <h2 style="color: #2E86C1;">🎟️ Booking Confirmed!</h2>
                                
                                <p>Hello <b>%s</b>,</p>
                                
                                <p>Your ticket has been booked successfully 🎉</p>
                                
                                <hr/>
                                
                                <p><b>Movie:</b> %s</p>
                                <p><b>Seat:</b> %s</p>
                                
                                <hr/>
                                
                                <p style="color: gray;">Enjoy your show 🍿</p>
                                
                            </div>
                            
                        </body>
                    </html>
                    """.formatted(userName, movie, seat);

            helper.setText(htmlContent, true);

            mailSender.send(message);

            System.out.println("✅ HTML Email sent successfully!");

        } catch (MessagingException e) {
            System.out.println("❌ EMAIL ERROR OCCURRED");
            e.printStackTrace();
        }
    }
}