package com.kodilla.exception.test;

public class FlightFinderRunner{
    public static void main(String[] args){
        Flight flight = new Flight("Wroclaw", "Berlin");
        FlightFinder flightFinder = new FlightFinder();

        try{
            flightFinder.findFlight(flight);
        } catch(RouteNotFoundException e) {
            System.out.println(e.toString());
        } finally {
            System.out.println("Program still working - You can search flight once more or fly away");
        }
        System.out.println();

        flight = new Flight("Wroclaw", "Pikutkowo Dolne");

        try{
            flightFinder.findFlight(flight);
        } catch(RouteNotFoundException e) {
            System.out.println(e.toString());
        } finally {
            System.out.println("Program still working - You can search flight once more or fly away");
        }System.out.println();

        flight = new Flight("Wroclaw", "Paris");

        try{
            flightFinder.findFlight(flight);
        } catch(RouteNotFoundException e) {
            System.out.println(e.toString());
        } finally {
            System.out.println("Program still working - You can search flight once more or fly away");
        }
    }
}
