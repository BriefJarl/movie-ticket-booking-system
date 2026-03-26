package com.bhumi.moviebooking.resource;

public class SearchResultResource {

    private String movieTitle;
    private String theaterName;
    private String city;
    private String showTime;

    public SearchResultResource(
            String movieTitle,
            String theaterName,
            String city,
            String showTime) {

        this.movieTitle = movieTitle;
        this.theaterName = theaterName;
        this.city = city;
        this.showTime = showTime;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public String getCity() {
        return city;
    }

    public String getShowTime() {
        return showTime;
    }
}