package com.bhumi.moviebooking.service;

import com.bhumi.moviebooking.repository.ShowRepository;
import com.bhumi.moviebooking.resource.SearchResultResource;
import com.bhumi.moviebooking.resource.ShowResponse;
import com.bhumi.moviebooking.resource.SeatResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    private final ShowRepository showRepository;

    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    public String createShow() {
        return "Show created successfully";
    }

    public String getAllShows() {
        return "All shows fetched successfully";
    }

    public String deleteShow(Long id) {
        return "Show with id " + id + " deleted successfully";
    }


    // Movie + City search
    public List<SearchResultResource> searchMovieByCity(String movieName, String city) {

        List<Object[]> results = showRepository.searchMovieByCity(movieName, city);

        List<SearchResultResource> response = new ArrayList<>();

        for (Object[] row : results) {

            SearchResultResource resource = new SearchResultResource(
                    (String) row[0],
                    (String) row[1],
                    (String) row[2],
                    row[3].toString()
            );

            response.add(resource);
        }

        return response;
    }


    // City search
    public List<SearchResultResource> searchByCity(String city) {

        List<Object[]> results = showRepository.findByCity(city);

        List<SearchResultResource> response = new ArrayList<>();

        for (Object[] row : results) {

            SearchResultResource resource = new SearchResultResource(
                    (String) row[0],
                    (String) row[1],
                    (String) row[2],
                    row[3].toString()
            );

            response.add(resource);
        }

        return response;
    }


    // Theatre + City search
    public List<SearchResultResource> searchByTheater(String theaterName, String city) {

        List<Object[]> results = showRepository.findByTheaterAndCity(theaterName, city);

        List<SearchResultResource> response = new ArrayList<>();

        for (Object[] row : results) {

            SearchResultResource resource = new SearchResultResource(
                    (String) row[0],
                    (String) row[1],
                    (String) row[2],
                    row[3].toString()
            );

            response.add(resource);
        }

        return response;
    }


    // REQUIRED FOR MovieController
    public List<ShowResponse> getShowsByMovie(Long movieId) {

        List<Object[]> results = showRepository.getShowsByMovie(movieId);

        List<ShowResponse> response = new ArrayList<>();

        for (Object[] row : results) {

            ShowResponse show = new ShowResponse(
                    ((Number) row[0]).longValue(),
                    row[1].toString(),
                    (String) row[2]
            );

            response.add(show);
        }

        return response;
    }


    public List<SeatResponse> getSeatsByMovie(Long movieId) {

        List<Object[]> results = showRepository.getSeatsByMovie(movieId);

        List<SeatResponse> response = new ArrayList<>();

        for (Object[] row : results) {

            SeatResponse seat = new SeatResponse(
                    ((Number) row[0]).longValue(),
                    (String) row[1],
                    (Boolean) row[2]
            );

            response.add(seat);
        }

        return response;
    }

}