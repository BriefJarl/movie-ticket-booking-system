package com.bhumi.moviebooking.repository;

import com.bhumi.moviebooking.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("SELECT AVG(r.rating) FROM Review r WHERE r.movie.id = :movieId")
    Double getReviewAverage(@Param("movieId") Long movieId);
}
