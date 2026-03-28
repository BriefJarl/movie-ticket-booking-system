package com.bhumi.moviebooking.controller;

import com.bhumi.moviebooking.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducerService producerService;

    @GetMapping("/book")
    public String bookTicket(
            @RequestParam String user,
            @RequestParam String movie,
            @RequestParam String seat) {

        // METHOD NAME
        producerService.sendTicketEvent(user, movie, seat);

        return "✅ Ticket booking event sent!";
    }
}