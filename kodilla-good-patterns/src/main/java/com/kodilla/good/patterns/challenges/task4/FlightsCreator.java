package com.kodilla.good.patterns.challenges.task4;

import java.util.HashSet;

public class FlightsCreator {
    final static String WROCLAW = "WROCŁAW";
    final static String KRAKOW = "KRAKÓW";
    final static String WARSZAWA = "WARSZAWA";
    final static String POZNAN = "POZNAŃ";
    final static String GDANSK = "GDAŃSK";
    final static String KATOWICE = "KATOWICE";
    final static String RADOM = "RADOM";
    final static String LODZ = "ŁÓDŹ";

    public HashSet<Flight> create(){
        HashSet<Flight> Flights = new HashSet<>();

        Flights.add(new Flight(WROCLAW, KRAKOW));
        Flights.add(new Flight(WROCLAW, WARSZAWA));
        Flights.add(new Flight(WROCLAW, GDANSK));
        Flights.add(new Flight(WROCLAW, POZNAN));

        Flights.add(new Flight(KRAKOW, RADOM));
        Flights.add(new Flight(KRAKOW, KATOWICE));
        Flights.add(new Flight(KRAKOW, WROCLAW));
        Flights.add(new Flight(KRAKOW, WARSZAWA));

        Flights.add(new Flight(WARSZAWA, LODZ));
        Flights.add(new Flight(WARSZAWA, KRAKOW));
        Flights.add(new Flight(WARSZAWA, KATOWICE));
        Flights.add(new Flight(WARSZAWA, WROCLAW));

        Flights.add(new Flight(POZNAN, LODZ));
        Flights.add(new Flight(POZNAN, GDANSK));
        Flights.add(new Flight(POZNAN, WROCLAW));
        Flights.add(new Flight(POZNAN, WARSZAWA));


        Flights.add(new Flight(GDANSK, WARSZAWA));
        Flights.add(new Flight(GDANSK, WROCLAW));
        Flights.add(new Flight(GDANSK, POZNAN));
        Flights.add(new Flight(GDANSK, LODZ));

        Flights.add(new Flight(KATOWICE, WROCLAW));

        Flights.add(new Flight(RADOM, KRAKOW));


        Flights.add(new Flight(LODZ, WARSZAWA));
        Flights.add(new Flight(LODZ, POZNAN));

        return Flights;
    }
}
