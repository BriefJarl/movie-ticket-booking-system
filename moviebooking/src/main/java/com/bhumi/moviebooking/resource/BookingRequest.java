package com.bhumi.moviebooking.resource;

import java.util.List;

public class BookingRequest {

    private List<String> seatNumbers;  // ["1A","1B"]
    private Long userId;
    private Long showId;
    private String seatType;

    // GETTERS

    public List<String> getSeatNumbers() {
        return seatNumbers;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getShowId() {
        return showId;
    }

    public String getSeatType() {
        return seatType;
    }

    // SETTERS

    public void setSeatNumbers(List<String> seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }
}