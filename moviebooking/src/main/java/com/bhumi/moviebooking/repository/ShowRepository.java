package com.bhumi.moviebooking.repository;

import com.bhumi.moviebooking.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Long> {

    // Movie + City search
    @Query(
            value = "SELECT m.title, t.name, t.city, s.show_time " +
                    "FROM shows s " +
                    "JOIN movies m ON s.movie_id = m.id " +
                    "JOIN theaters t ON s.theater_id = t.id " +
                    "WHERE m.title = ?1 " +
                    "AND t.city = ?2",
            nativeQuery = true
    )
    List<Object[]> searchMovieByCity(String movieName, String city);


    // City search
    @Query(
            value = "SELECT m.title, t.name, t.city, s.show_time " +
                    "FROM shows s " +
                    "JOIN movies m ON s.movie_id = m.id " +
                    "JOIN theaters t ON s.theater_id = t.id " +
                    "WHERE t.city = :city",
            nativeQuery = true
    )
    List<Object[]> findByCity(@Param("city") String city);


    // Theater + City search
    @Query(
            value = "SELECT m.title, t.name, t.city, s.show_time " +
                    "FROM shows s " +
                    "JOIN movies m ON s.movie_id = m.id " +
                    "JOIN theaters t ON s.theater_id = t.id " +
                    "WHERE t.name = :theaterName AND t.city = :city",
            nativeQuery = true
    )
    List<Object[]> findByTheaterAndCity(
            @Param("theaterName") String theaterName,
            @Param("city") String city
    );


    // ⭐ Get shows by movie
    @Query(
            value = "SELECT s.id, s.show_time, t.name " +
                    "FROM shows s " +
                    "JOIN theaters t ON s.theater_id = t.id " +
                    "WHERE s.movie_id = :movieId",
            nativeQuery = true
    )
    List<Object[]> getShowsByMovie(@Param("movieId") Long movieId);


    // ⭐ Seats by movie
    @Query(
            value = "SELECT ss.id, ss.seat_number, ss.available " +
                    "FROM show_seats ss " +
                    "JOIN shows s ON ss.show_id = s.id " +
                    "WHERE s.movie_id = :movieId",
            nativeQuery = true
    )
    List<Object[]> getSeatsByMovie(@Param("movieId") Long movieId);

}