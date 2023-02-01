package com.kodilla.hibernate.cinema;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "SEATS")
public class Seat {

    private int id;
    private int row;
    private char seat;
    private boolean occupied = false;

    public Seat() {
    }

    public Seat(int row, char seat) {
        this.row = row;
        this.seat = seat;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "SEAT_ID")
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "SEAT_ROW")
    public int getRow() {
        return row;
    }

    @NotNull
    @Column(name = "SEAT_CHAR")
    public char getSeat() {
        return seat;
    }

    @NotNull
    @Column(name = "IS_SEAT_OCCUPIED")
    public boolean isOccupied() {
        return occupied;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setSeat(char seat) {
        this.seat = seat;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}
