package com.bhumi.moviebooking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seatNumber;   // like A1, A2

    private boolean available = true;

    // Many seats belong to one show
    @ManyToOne
    @JoinColumn(name = "show_id")
    @JsonIgnore
    private Show show;

    // getters

    public Long getId() {
        return id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public Show getShow() {
        return show;
    }

    // setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setShow(Show show) {
        this.show = show;
    }
}