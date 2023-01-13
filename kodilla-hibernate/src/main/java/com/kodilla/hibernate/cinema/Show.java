package com.kodilla.hibernate.cinema;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SHOWS")
public class Show {

    private int id;
    private Movie movie;
    private LocalDateTime startTime;
    private List<Ticket> tickets = new ArrayList<>();
    private Room room;

    public Show() {
    }

    public Show(Movie movie, LocalDateTime startTime) {
        this.movie = movie;
        this.startTime = startTime;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "SHOW_ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "MOVIE_ID")
    public Movie getMovie() {
        return movie;
    }

    @NotNull
    @Column(name = "SHOW_START_TIME")
    public LocalDateTime getStartTime() {
        return startTime;
    }

    @OneToMany(
            targetEntity = Ticket.class,
            mappedBy = "id",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    public List<Ticket> getTickets() {
        return tickets;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setMovie(Movie movie) {
        this.movie = movie;
    }

    private void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    private void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ROOM_ID")
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
