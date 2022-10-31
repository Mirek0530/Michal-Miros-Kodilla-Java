package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {

    public void findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> flightsMap = new HashMap<>();

        flightsMap.put("ParisCDG", true);
        flightsMap.put("LondonLHR", true);
        flightsMap.put("FrankfurtFRA", true);
        flightsMap.put("RadomRDO", false);
        flightsMap.put("SydneySYD", true);
        flightsMap.put("MadridMAD", true);
        flightsMap.put("RioDeJaneiroGIG", true);

        if (flightsMap.containsKey(flight.getDepartureAirport()) && flightsMap.containsKey(flight.getArrivalAirport())) {
            if (flightsMap.get(flight.getDepartureAirport()) && flightsMap.get(flight.getArrivalAirport())) {
                System.out.println("Flight found! From " + flight.getDepartureAirport() + ", to: " + flight.getArrivalAirport());
            } else {
                System.out.println("One of requested airports is currently unavailable. Sorry.");
            }
        } else {
            throw new RouteNotFoundException();
        }

    }
}
