package com.bhumi.moviebooking.service;

import com.bhumi.moviebooking.entity.Movie;
import com.bhumi.moviebooking.repository.MovieRepository;
import com.bhumi.moviebooking.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // Save Movie
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    //Get All Movies
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    //Get Movie By ID (Professional 404 handling)
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Movie not found with id " + id));
    }

    //Delete Movie (Also throw 404 if not found)
    public void deleteMovie(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Movie not found with id " + id));

        movieRepository.delete(movie);
    }

    //Update Movie (Also throw 404 if not found)
    public Movie updateMovie(Long id, Movie updatedMovie) {

        Movie movie = movieRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Movie not found with id " + id));

        movie.setTitle(updatedMovie.getTitle());
        movie.setGenre(updatedMovie.getGenre());
        movie.setDuration(updatedMovie.getDuration());

        return movieRepository.save(movie);
    }
}
