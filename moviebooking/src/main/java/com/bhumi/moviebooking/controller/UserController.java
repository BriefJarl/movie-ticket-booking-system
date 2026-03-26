package com.bhumi.moviebooking.controller;

import com.bhumi.moviebooking.service.UserService;
import com.bhumi.moviebooking.service.TicketService; //  ADD THIS
import com.bhumi.moviebooking.resource.BookingResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final TicketService ticketService;

    public UserController(UserService userService, TicketService ticketService) {
        this.userService = userService;
        this.ticketService = ticketService;
    }

    @PostMapping
    public String createUser() {
        return userService.createUser();
    }

    @GetMapping
    public String getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    @GetMapping("/{userId}/bookings")
    public List<BookingResponse> getUserBookings(@PathVariable Long userId) {
        return ticketService.getBookingsByUser(userId);
    }
}