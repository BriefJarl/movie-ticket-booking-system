package com.bhumi.moviebooking.controller;

import com.bhumi.moviebooking.service.TheaterService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theaters")
public class TheaterController {

    private final TheaterService theaterService;

    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @PostMapping
    public String createTheater() {
        return theaterService.createTheater();
    }

    @GetMapping
    public String getAllTheaters() {
        return theaterService.getAllTheaters();
    }

    @DeleteMapping("/{id}")
    public String deleteTheater(@PathVariable Long id) {
        return theaterService.deleteTheater(id);
    }
}