package com.bhumi.moviebooking.service;

import com.bhumi.moviebooking.model.TicketEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final String TOPIC = "movie-topic";

    @Autowired
    private KafkaTemplate<String, TicketEvent> jsonkafkaTemplate;

    // 🔥 THIS METHOD MUST EXIST
    public void sendTicketEvent(String user, String movie, String seat) {

        TicketEvent event = new TicketEvent(user, movie, seat);

        jsonkafkaTemplate.send(TOPIC, event);

        System.out.println("🔥 Event sent to Kafka: " + event);
    }
}