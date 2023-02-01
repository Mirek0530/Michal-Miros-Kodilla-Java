package com.kodilla.hibernate.cinema;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ROOMS")
public class Room {

    private int id;
    private int seats;
    private List<Show> shows;

    public Room() {
    }

    public Room(int id, int seats) {
        this.id = id;
        this.seats = seats;
        this.shows = new ArrayList<>();
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ROOM_ID")
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "SEATS")
    public int getSeats() {
        return seats;
    }

    @OneToMany(
            targetEntity = Show.class,
            mappedBy = "id",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    public List<Show> getShows() {
        return shows;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setSeats(int seats) {
        this.seats = seats;
    }

    private void setShows(List<Show> shows) {
        this.shows = shows;
    }
}
