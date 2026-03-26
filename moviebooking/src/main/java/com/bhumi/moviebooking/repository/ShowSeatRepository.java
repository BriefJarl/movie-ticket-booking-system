package com.bhumi.moviebooking.repository;

import com.bhumi.moviebooking.entity.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

    // 🔥 FINAL WORKING METHOD (uses entity mapping correctly)
    List<ShowSeat> findByShow_IdAndSeatNumberIn(Long showId, List<String> seatNumbers);
}