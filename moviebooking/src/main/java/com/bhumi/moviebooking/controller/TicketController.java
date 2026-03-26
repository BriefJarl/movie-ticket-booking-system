package com.bhumi.moviebooking.controller;

import com.bhumi.moviebooking.entity.Ticket;
import com.bhumi.moviebooking.resource.BookingResource;
import com.bhumi.moviebooking.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/book")
    public ResponseEntity<Ticket> bookTicket(@RequestBody BookingResource bookingResource) {
        return ResponseEntity.ok(ticketService.bookTicket(bookingResource));
    }
}