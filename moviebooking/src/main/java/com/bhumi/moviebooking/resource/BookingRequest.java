package com.bhumi.moviebooking.resource;

import java.util.List;

public class BookingRequest {

    private List<String> seatNumbers; 
    private Long userId;
    private Long showId;
    private String seatType;


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
