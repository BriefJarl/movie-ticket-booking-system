package com.bhumi.moviebooking.repository;

import com.bhumi.moviebooking.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query(
            value = "SELECT t.id, s.show_time, m.title " +
                    "FROM tickets t " +
                    "JOIN bookings b ON t.booking_id = b.id " +
                    "JOIN shows s ON b.show_id = s.id " +
                    "JOIN movies m ON s.movie_id = m.id " +
                    "WHERE b.user_id = :userId",
            nativeQuery = true
    )
    List<Object[]> getBookingsByUser(@Param("userId") Long userId);

}