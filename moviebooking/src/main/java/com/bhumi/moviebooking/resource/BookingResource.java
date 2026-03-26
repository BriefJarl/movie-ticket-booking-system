package com.bhumi.moviebooking.resource;

import java.util.List;

public class BookingResource {

    private Long id;
    private Long userId;
    private Long showId;
    private List<String> seatNumbers;

    public BookingResource() {}

    public BookingResource(Long id, Long userId, Long showId, List<String> seatNumbers) {
        this.id = id;
        this.userId = userId;
        this.showId = showId;
        this.seatNumbers = seatNumbers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public List<String> getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(List<String> seatNumbers) {
        this.seatNumbers = seatNumbers;
    }
}