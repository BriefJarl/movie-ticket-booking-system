package com.bhumi.moviebooking.controller;

import com.bhumi.moviebooking.entity.Movie;
import com.bhumi.moviebooking.resource.ShowResponse;
import com.bhumi.moviebooking.resource.SeatResponse;
import com.bhumi.moviebooking.service.MovieService;
import com.bhumi.moviebooking.service.ShowService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;
    private final ShowService showService;

    public MovieController(MovieService movieService, ShowService showService) {
        this.movieService = movieService;
        this.showService = showService;
    }

    // Add Movie
    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.saveMovie(movie);
    }

    // Get All Movies
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    // Get Movie By ID
    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    // Update Movie
    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        return movieService.updateMovie(id, movie);
    }

    // Delete Movie
    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }

    // Get Shows By Movie
    @GetMapping("/{movieId}/shows")
    public List<ShowResponse> getShowsByMovie(@PathVariable Long movieId) {
        return showService.getShowsByMovie(movieId);
    }

    @GetMapping("/{movieId}/seats")
    public List<SeatResponse> getSeatsByMovie(@PathVariable Long movieId) {
        return showService.getSeatsByMovie(movieId);
    }
}