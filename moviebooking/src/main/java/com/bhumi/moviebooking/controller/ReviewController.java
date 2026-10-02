package com.bhumi.moviebooking.controller;

import com.bhumi.moviebooking.service.ReviewService;
import com.bhumi.moviebooking.service.request.ReviewRequest;
import com.bhumi.moviebooking.service.response.ReviewResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/add")
    public ReviewResponse addReview(@Valid @RequestBody ReviewRequest reviewRequest) {
        return reviewService.addReview(reviewRequest);
    }

    @GetMapping("/find")
    public ReviewResponse getReviewById(@RequestParam(name = "reviewId") Long reviewId) {
        return reviewService.getReviewById(reviewId);
    }
}