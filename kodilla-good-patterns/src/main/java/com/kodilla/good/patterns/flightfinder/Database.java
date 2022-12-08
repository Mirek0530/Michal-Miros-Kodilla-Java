package com.kodilla.good.patterns.flightfinder;

import java.util.Set;

public interface Database {

    void addFlight(Flight flight);

    Set<Flight> getFlights();
}
