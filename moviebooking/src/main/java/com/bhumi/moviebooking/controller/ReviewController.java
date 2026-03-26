package com.bhumi.moviebooking.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @GetMapping
    public String getReviews() {
        return "All Reviews";
    }
}