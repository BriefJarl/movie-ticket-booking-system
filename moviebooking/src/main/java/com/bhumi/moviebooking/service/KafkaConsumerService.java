package com.bhumi.moviebooking.service;

import com.bhumi.moviebooking.model.TicketEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @Autowired
    private EmailService emailService;

    @KafkaListener(topics = "movie-topic", groupId = "movie-group-json-1")
    public void consumeJson(TicketEvent event) {

        System.out.println("=================================");
        System.out.println("🔥 EVENT RECEIVED FROM KAFKA");
        System.out.println("User: " + event.getUser());
        System.out.println("Movie: " + event.getMovie());
        System.out.println("Seat: " + event.getSeat());
        System.out.println("=================================");

        try {
            String to = "codersamurai.96@gmail.com";

            // (ADD THIS)
            System.out.println("📧 Sending email to: " + to);

            emailService.sendTicketEmail(
                    to,
                    event.getUser(),
                    event.getMovie(),
                    event.getSeat()
            );

            System.out.println("✅ Email function called successfully!");

        } catch (Exception e) {
            System.out.println("❌ Email sending failed");
            e.printStackTrace();
        }
    }
}