package com.kodilla.exception.test;

public class FlightFinderRunner {
    public static void main(String[] args) {
        FlightFinder flightFinder = new FlightFinder();
        Flight flight = new Flight("FrankfurtFRA", "LondonLHR");

        try {
            flightFinder.findFlight(flight);
        } catch (RouteNotFoundException e) {
            System.out.println("Airport not found!");
        } finally {
            System.out.println("Thank you for using FlightFinder.");
        }
    }
}
