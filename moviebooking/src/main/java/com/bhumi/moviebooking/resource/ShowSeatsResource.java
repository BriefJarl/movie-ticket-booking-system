package com.bhumi.moviebooking.resource;

public class ShowSeatsResource {

    private Long id;
    private Long showId;
    private String seatNumber;

    public ShowSeatsResource() {}

    public ShowSeatsResource(Long id, Long showId, String seatNumber) {
        this.id = id;
        this.showId = showId;
        this.seatNumber = seatNumber;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getShowId() { return showId; }
    public void setShowId(Long showId) { this.showId = showId; }

    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }
}