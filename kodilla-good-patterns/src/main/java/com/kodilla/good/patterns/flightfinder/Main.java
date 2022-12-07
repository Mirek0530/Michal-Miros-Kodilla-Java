package com.kodilla.good.patterns.flightfinder;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Airport gdansk = new Airport("GDANSK");
        Airport warszawa = new Airport("WARSZAWA");
        Airport wroclaw = new Airport("WROCLAW");
        Airport poznan = new Airport("POZNAN");
        Airport krakow = new Airport("KRAKOW");

        Flight gdakra = new Flight(gdansk, krakow);
        Flight gdapoz = new Flight(gdansk, poznan);
        Flight krawro = new Flight(krakow, wroclaw);
        Flight krapoz = new Flight(krakow, poznan);
        Flight warwro = new Flight(warszawa, wroclaw);
        Flight pozgda = new Flight(poznan, gdansk);

        FlightDatabase flightDatabase = new FlightDatabase();

        flightDatabase.addFlight(gdakra);
        flightDatabase.addFlight(gdapoz);
        flightDatabase.addFlight(krawro);
        flightDatabase.addFlight(krapoz);
        flightDatabase.addFlight(warwro);
        flightDatabase.addFlight(pozgda);

        FlightFinderService flightFinderService = new FlightFinderService(flightDatabase);

        Set<Flight> departures = flightFinderService.findDepartures(krakow);
        System.out.println(departures);

        Set<Flight> arrivals = flightFinderService.findArrivals(wroclaw);
        System.out.println(arrivals);

        Set<Flight> connectingFlights = flightFinderService.findConnectingFlights(gdansk, wroclaw, krakow);
        System.out.println(connectingFlights);

    }
}
