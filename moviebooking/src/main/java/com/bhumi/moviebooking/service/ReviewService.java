package com.bhumi.moviebooking.service;

import com.bhumi.moviebooking.entity.Movie;
import com.bhumi.moviebooking.entity.Review;
import com.bhumi.moviebooking.exception.ResourceNotFoundException;
import com.bhumi.moviebooking.repository.MovieRepository;
import com.bhumi.moviebooking.repository.ReviewRepository;
import com.bhumi.moviebooking.service.request.ReviewRequest;
import com.bhumi.moviebooking.service.response.ReviewResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewService {

    private final MovieRepository movieRepository;
    private final ReviewRepository reviewRepository;

    public ReviewService(MovieRepository movieRepository, ReviewRepository reviewRepository) {
        this.movieRepository = movieRepository;
        this.reviewRepository = reviewRepository;
    }

    @Transactional
    public ReviewResponse addReview(ReviewRequest reviewRequest) {
        Movie movie = movieRepository.findById(reviewRequest.getMovieId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Movie not found with id " + reviewRequest.getMovieId()));

        Review review = new Review();
        review.setMovie(movie);
        review.setMovieReview(reviewRequest.getReview());
        review.setRating(reviewRequest.getRating());

        reviewRepository.save(review);

        Double average = reviewRepository.getReviewAverage(movie.getId());
        if (average != null) {
            movie.setRating(average);
        } else {
            movie.setRating(reviewRequest.getRating());
        }

        movieRepository.save(movie);

        return new ReviewResponse(
                review.getMovieReview(),
                review.getRating(),
                movie.getId()
        );
    }

    public ReviewResponse getReviewById(Long reviewId) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Review not found with id " + reviewId));

        return new ReviewResponse(
                review.getMovieReview(),
                review.getRating(),
                review.getMovie().getId()
        );
    }
}