package com.kodilla.good.patterns.challenges.task4;

public class Flight {
    private String arrivalAirport;
    private String departureAirport;

    public Flight(String departureAirport, String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
        this.departureAirport = departureAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Flight flight = (Flight) o;

        if (!arrivalAirport.equals(flight.arrivalAirport)) {
            return false;
        }
        return departureAirport.equals(flight.departureAirport);

    }

    @Override
    public int hashCode() {
        int result = arrivalAirport.hashCode();
        result = 31 * result + departureAirport.hashCode();
        return result;
    }
}
