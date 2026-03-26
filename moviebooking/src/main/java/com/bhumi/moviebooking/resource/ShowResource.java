package com.bhumi.moviebooking.resource;

import java.time.LocalDateTime;

public class ShowResource {

    private Long id;
    private Long movieId;
    private Long theaterId;
    private LocalDateTime showTime;

    public ShowResource() {}

    public ShowResource(Long id, Long movieId, Long theaterId, LocalDateTime showTime) {
        this.id = id;
        this.movieId = movieId;
        this.theaterId = theaterId;
        this.showTime = showTime;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getMovieId() { return movieId; }
    public void setMovieId(Long movieId) { this.movieId = movieId; }

    public Long getTheaterId() { return theaterId; }
    public void setTheaterId(Long theaterId) { this.theaterId = theaterId; }

    public LocalDateTime getShowTime() { return showTime; }
    public void setShowTime(LocalDateTime showTime) { this.showTime = showTime; }
}