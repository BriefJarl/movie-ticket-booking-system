package com.bhumi.moviebooking.resource;

public class BookingResponse {

    private Long ticketId;
    private String showTime;
    private String movie;

    public BookingResponse(Long ticketId, String showTime, String movie) {
        this.ticketId = ticketId;
        this.showTime = showTime;
        this.movie = movie;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public String getShowTime() {
        return showTime;
    }

    public String getMovie() {
        return movie;
    }
}