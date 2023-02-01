package com.kodilla.hibernate.cinema;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "TICKETS")
public class Ticket {

    private int id;
    private Seat seat;
    private BigDecimal price;

    public Ticket() {
    }

    public Ticket(Seat seat, BigDecimal price) {
        this.seat = seat;
        this.price = price;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "TICKET_ID")
    public int getId() {
        return id;
    }

    @NotNull
    @OneToOne
    @JoinColumn(name = "SEAT_ID")
    public Seat getSeat() {
        return seat;
    }

    @NotNull
    @Column(name = "PRICE")
    public BigDecimal getPrice() {
        return price;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setSeat(Seat seat) {
        this.seat = seat;
    }

    private void setPrice(BigDecimal price) {
        this.price = price;
    }
}
