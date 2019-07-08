package com.kodilla.good.patterns.challenges.task4;

import java.util.Set;
import java.util.stream.Collectors;

public class AllFlights {
    private Set<Flight> flightsSet;

    public AllFlights(Set<Flight> flightsSet) {
        this.flightsSet = flightsSet;
    }

    public String findFlightsFrom(String departureAirport) {
        return flightsSet.stream().
                filter(flight -> flight.getDepartureAirport().equals(departureAirport))
                .map(Flight::getArrivalAirport)
                .collect(Collectors.joining(", ", "You can fly from " + departureAirport + " to: ", "."));

    }

    public String findFlightsTo(String arrivalAirport) {
        return flightsSet.stream()
                .filter(flight -> flight.getArrivalAirport().equals(arrivalAirport))
                .map(Flight::getDepartureAirport)
                .collect(Collectors.joining(", ", "You can fly to " + arrivalAirport + " from: ", "."));

    }

    public String findTransitAirportsFromTo(String departureAirport, String arrivalAirport) {
        String prefix;
        if (findFlightsFrom(departureAirport).contains(arrivalAirport)) {
            prefix = "You can fly directly from " + departureAirport +
                    " to " + arrivalAirport + " or via: ";
        } else {
            prefix = "You can fly from " + departureAirport +
                    " to " + arrivalAirport + " via: ";
        }
        return flightsSet.stream().
                filter(flight -> flight.getDepartureAirport().equals(departureAirport))
                .map(Flight::getArrivalAirport)
                .filter(transitAirport -> flightsSet.stream()
                        .filter(flight -> flight.getDepartureAirport().equals(transitAirport))
                        .map(Flight::getArrivalAirport)
                        .collect(Collectors.joining()).contains(arrivalAirport))
                .collect(Collectors.joining(", ", prefix, "."));
    }
}
