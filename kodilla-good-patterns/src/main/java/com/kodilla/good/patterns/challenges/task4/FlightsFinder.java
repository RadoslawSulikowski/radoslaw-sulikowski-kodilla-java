package com.kodilla.good.patterns.challenges.task4;

public class FlightsFinder {

    public static void main(String[] args){
        FlightsCreator flightsCreator = new FlightsCreator();
        AllFlights allFlights = new AllFlights(flightsCreator.create());

        System.out.println(allFlights.findFlightsFrom(FlightsCreator.WROCLAW));

        System.out.println(allFlights.findFlightsTo(FlightsCreator.WARSZAWA));

        System.out.println(allFlights.findTransitAirportsFromTo(FlightsCreator.WROCLAW, FlightsCreator.WARSZAWA));

        System.out.println(allFlights.findTransitAirportsFromTo(FlightsCreator.WROCLAW, FlightsCreator.RADOM));

    }
}
