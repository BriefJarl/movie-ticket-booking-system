package com.bhumi.moviebooking.resource;

public class ReviewResource {

    private Long id;
    private String comment;
    private int rating;

    public ReviewResource() {}

    public ReviewResource(Long id, String comment, int rating) {
        this.id = id;
        this.comment = comment;
        this.rating = rating;
    }

    // getters setters
}