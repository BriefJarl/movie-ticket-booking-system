package com.bhumi.moviebooking.service;

import org.springframework.stereotype.Service;

@Service
public class TheaterService {

    public String createTheater() {
        return "Theater created successfully";
    }

    public String getAllTheaters() {
        return "All theaters fetched successfully";
    }

    public String deleteTheater(Long id) {
        return "Theater with id " + id + " deleted successfully";
    }
}