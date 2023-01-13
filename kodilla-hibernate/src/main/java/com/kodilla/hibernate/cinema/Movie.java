package com.kodilla.hibernate.cinema;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "MOVIES")
public class Movie {

    private int id;
    private String title;
    private int duration;

    public Movie() {
    }

    public Movie(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "MOVIE_ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "MOVIE_TITLE")
    public String getTitle() {
        return title;
    }

    @NotNull
    @Column(name = "MOVIE_DURATION")
    public int getDuration() {
        return duration;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setDuration(int duration) {
        this.duration = duration;
    }
}
