package com.bhumi.moviebooking.controller;

import com.bhumi.moviebooking.resource.SearchResultResource;
import com.bhumi.moviebooking.service.ShowService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowController {

    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    // Create Show
    @PostMapping
    public String createShow() {
        return showService.createShow();
    }

    // Get All Shows
    @GetMapping
    public String getAllShows() {
        return showService.getAllShows();
    }

    // Delete Show
    @DeleteMapping("/{id}")
    public String deleteShow(@PathVariable Long id) {
        return showService.deleteShow(id);
    }


    // ⭐ Smart Search API
    @GetMapping("/search")
    public List<SearchResultResource> searchShows(

            @RequestParam(name = "city") String city,

            @RequestParam(name = "movieName", required = false) String movieName,

            @RequestParam(name = "theaterName", required = false) String theaterName
    ) {

        if (movieName != null) {
            return showService.searchMovieByCity(movieName, city);
        }

        if (theaterName != null) {
            return showService.searchByTheater(theaterName, city);
        }

        return showService.searchByCity(city);
    }
}