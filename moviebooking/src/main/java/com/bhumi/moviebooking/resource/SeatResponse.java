package com.bhumi.moviebooking.resource;

public class SeatResponse {

    private Long seatId;
    private String seatNumber;
    private boolean available;

    public SeatResponse(Long seatId, String seatNumber, boolean available) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.available = available;
    }

    public Long getSeatId() {
        return seatId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public boolean isAvailable() {
        return available;
    }
}