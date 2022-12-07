package com.kodilla.good.patterns.flightfinder;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class FlightFinderService {

    private Database database;

    public FlightFinderService(Database database) {
        this.database = database;
    }

    public Set<Flight> findDepartures(Airport airport) {
        return database.getFlights().stream()
                .filter(f -> f.getDepartureAirport().equals(airport))
                .collect(toSet());
    }

    public Set<Flight> findArrivals(Airport airport) {
        return database.getFlights().stream()
                .filter(f -> f.getArrivalAirport().equals(airport))
                .collect(toSet());
    }

    public Set<Flight> findConnectingFlights(Airport departureAirport, Airport arrivalAirport, Airport intermediateAirport) {
        return database.getFlights().stream()
                .filter(f -> (f.getDepartureAirport().equals(departureAirport) && f.getArrivalAirport().equals(intermediateAirport))
                || (f.getDepartureAirport().equals(intermediateAirport) && f.getArrivalAirport().equals(arrivalAirport)))
                .collect(toSet());
    }
}
