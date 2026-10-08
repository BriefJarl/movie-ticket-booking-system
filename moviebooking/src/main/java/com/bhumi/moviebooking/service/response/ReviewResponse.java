package com.bhumi.moviebooking.service.response;

public class ReviewResponse {

    private String review;
    private Double rating;
    private Long movieId;

    public ReviewResponse() {}

    public ReviewResponse(String review, Double rating, Long movieId) {
        this.review = review;
        this.rating = rating;
        this.movieId = movieId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
}
