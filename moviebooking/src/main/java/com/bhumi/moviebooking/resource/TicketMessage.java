package com.bhumi.moviebooking.resource;

public class TicketMessage {

    private String message;

    public TicketMessage() {}

    public TicketMessage(String message) {
        this.message = message;
    }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}