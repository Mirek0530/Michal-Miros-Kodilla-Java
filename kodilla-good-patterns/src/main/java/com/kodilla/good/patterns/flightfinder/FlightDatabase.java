package com.kodilla.good.patterns.flightfinder;

import java.util.HashSet;
import java.util.Set;

public class FlightDatabase implements Database {

    private Set<Flight> flights;

    public FlightDatabase() {
        this.flights = new HashSet<>();
    }

    @Override
    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    @Override
    public Set<Flight> getFlights() {
        return this.flights;
    }
}
