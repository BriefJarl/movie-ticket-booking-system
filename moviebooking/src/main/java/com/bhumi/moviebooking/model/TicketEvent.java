package com.bhumi.moviebooking.model;

public class TicketEvent {

    private String user;
    private String movie;
    private String seat;

    public TicketEvent() {}

    public TicketEvent(String user, String movie, String seat) {
        this.user = user;
        this.movie = movie;
        this.seat = seat;
    }

    public String getUser() {
        return user;
    }

    public String getMovie() {
        return movie;
    }

    public String getSeat() {
        return seat;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}