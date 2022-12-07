package com.kodilla.good.patterns.flightfinder;

import java.util.HashSet;
import java.util.Set;

public abstract class Database {
    private Set<Flight> flights;

    public Database() {
        this.flights = new HashSet<>();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public Set<Flight> getFlights() {
        return flights;
    }
}
