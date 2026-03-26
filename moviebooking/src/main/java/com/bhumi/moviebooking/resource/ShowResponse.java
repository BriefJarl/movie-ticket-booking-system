package com.bhumi.moviebooking.resource;

public class ShowResponse {

    private Long showId;
    private String showTime;
    private String theater;

    public ShowResponse(Long showId, String showTime, String theater) {
        this.showId = showId;
        this.showTime = showTime;
        this.theater = theater;
    }

    public Long getShowId() {
        return showId;
    }

    public String getShowTime() {
        return showTime;
    }

    public String getTheater() {
        return theater;
    }
}