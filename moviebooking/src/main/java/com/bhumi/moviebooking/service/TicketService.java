package com.bhumi.moviebooking.service;

import com.bhumi.moviebooking.entity.Show;
import com.bhumi.moviebooking.entity.ShowSeat;
import com.bhumi.moviebooking.entity.Ticket;
import com.bhumi.moviebooking.entity.User;
import com.bhumi.moviebooking.repository.TicketRepository;
import com.bhumi.moviebooking.repository.ShowSeatRepository;
import com.bhumi.moviebooking.repository.ShowRepository;
import com.bhumi.moviebooking.repository.UserRepository;
import com.bhumi.moviebooking.resource.BookingResponse;
import com.bhumi.moviebooking.resource.BookingResource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// ADD THIS IMPORT
import com.bhumi.moviebooking.service.KafkaProducerService;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final ShowSeatRepository showSeatRepository;
    private final ShowRepository showRepository;
    private final UserRepository userRepository;

    // ADD THIS FIELD
    private final KafkaProducerService kafkaProducerService;

    // UPDATED CONSTRUCTOR
    public TicketService(TicketRepository ticketRepository,
                         ShowSeatRepository showSeatRepository,
                         ShowRepository showRepository,
                         UserRepository userRepository,
                         KafkaProducerService kafkaProducerService) {

        this.ticketRepository = ticketRepository;
        this.showSeatRepository = showSeatRepository;
        this.showRepository = showRepository;
        this.userRepository = userRepository;
        this.kafkaProducerService = kafkaProducerService;
    }

    // FINAL WORKING METHOD
    public Ticket bookTicket(BookingResource bookingResource) {

        System.out.println("Incoming seats: " + bookingResource.getSeatNumbers());

        // ✅ Fetch User
        User user = userRepository.findById(bookingResource.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // ✅ Fetch Show
        Show show = showRepository.findById(bookingResource.getShowId())
                .orElseThrow(() -> new RuntimeException("Show not found"));

        // ✅ Normalize seat input
        List<String> normalizedSeats = bookingResource.getSeatNumbers()
                .stream()
                .map(s -> s.trim().toUpperCase())
                .collect(Collectors.toList());

        System.out.println("Normalized seats: " + normalizedSeats);

        // Fetch seats
        List<ShowSeat> selectedSeats =
                showSeatRepository.findByShow_IdAndSeatNumberIn(
                        show.getId(),
                        normalizedSeats
                );

        System.out.println("Selected seats count: " + selectedSeats.size());

        // If seats not found
        if (selectedSeats.isEmpty()) {
            throw new RuntimeException("Seats not found or mismatch");
        }

        // Check already booked
        for (ShowSeat seat : selectedSeats) {
            if (!seat.isAvailable()) {
                throw new RuntimeException("Seat already booked: " + seat.getSeatNumber());
            }
        }

        // ✅ Create ticket
        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticket.setShow(show);
        ticket.setSeats(selectedSeats);
        ticket.setAmount(selectedSeats.size() * 100);

        Ticket savedTicket = ticketRepository.save(ticket);

        // ✅ Update seat availability
        for (ShowSeat seat : selectedSeats) {
            seat.setAvailable(false);
            showSeatRepository.save(seat);
        }

        // KAFKA EVENT (MOST IMPORTANT)
        kafkaProducerService.sendTicketEvent(
                user.getName(),
                "Movie-" + show.getMovieId(),
                selectedSeats.get(0).getSeatNumber()
        );

        System.out.println("🔥 Kafka event sent from TicketService");

        return savedTicket;
    }

    // ✅ Cancel Ticket
    public String cancelTicket(Long id) {
        return "Ticket with id " + id + " cancelled successfully";
    }

    // ✅ Get bookings by user
    public List<BookingResponse> getBookingsByUser(Long userId) {

        List<Object[]> results = ticketRepository.getBookingsByUser(userId);

        List<BookingResponse> response = new ArrayList<>();

        for (Object[] row : results) {

            BookingResponse booking = new BookingResponse(
                    ((Number) row[0]).longValue(),
                    row[1].toString(),
                    (String) row[2]
            );

            response.add(booking);
        }

        return response;
    }
}