package com.kodilla.hibernate.cinema;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "TICKETS")
public class Ticket {

    private int id;
    private int seat;
    private BigDecimal price;

    public Ticket() {
    }

    public Ticket(int seat, BigDecimal price) {
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
    @Column(name = "SEAT")
    public int getSeat() {
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

    private void setSeat(int seat) {
        this.seat = seat;
    }

    private void setPrice(BigDecimal price) {
        this.price = price;
    }
}
