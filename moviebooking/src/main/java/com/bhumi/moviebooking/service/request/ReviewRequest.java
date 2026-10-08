package com.bhumi.moviebooking.service.request;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ReviewRequest {

    @NotNull(message = "Movie ID cannot be null")
    private Long movieId;

    @NotNull(message = "Rating cannot be null")
    @DecimalMin(value = "1.0", message = "Rating must be at least 1")
    @DecimalMax(value = "5.0", message = "Rating must be at most 5")
    private Double rating;

    @NotBlank(message = "Review cannot be empty")
    private String review;

    public ReviewRequest() {}

    public ReviewRequest(Long movieId, Double rating, String review) {
        this.movieId = movieId;
        this.rating = rating;
        this.review = review;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
