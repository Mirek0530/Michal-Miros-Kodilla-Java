package com.kodilla.hibernate.cinema.dto;

import com.kodilla.hibernate.cinema.Movie;
import com.kodilla.hibernate.cinema.Ticket;

import java.time.LocalDateTime;
import java.util.List;

public class ShowDto {
    private int id;
    private Movie movie;
    private LocalDateTime startTime;
    private List<Ticket> tickets;
    private int roomId;

    public int getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public int getRoomId() {
        return roomId;
    }
}
