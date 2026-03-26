package com.bhumi.moviebooking.resource;

public class TicketResource {

    private Long id;
    private Long bookingId;
    private String seatNumber;

    public TicketResource() {}

    public TicketResource(Long id, Long bookingId, String seatNumber) {
        this.id = id;
        this.bookingId = bookingId;
        this.seatNumber = seatNumber;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getBookingId() { return bookingId; }
    public void setBookingId(Long bookingId) { this.bookingId = bookingId; }

    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }
}