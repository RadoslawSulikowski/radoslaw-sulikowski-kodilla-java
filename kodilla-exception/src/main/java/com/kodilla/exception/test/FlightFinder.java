package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder{
    private HashMap<String, Boolean> mapCreator(){
        HashMap<String, Boolean> map = new HashMap<>();
        map.put("Paris", true);
        map.put("London", true);
        map.put("Moscow", false);
        map.put("Warsaw", true);
        map.put("Athene", false);
        map.put("Roma", true);
        map.put("Madrid", false);
        map.put("Lisbon", true);
        map.put("Berlin", false);
        map.put("Prague", true);
        map.put("Oslo", false);
        map.put("Helsinki", true);
        map.put("Sophia", false);
        map.put("Reykjavik", true);
        map.put("Brussels", false);

        return map;
    }
    public void findFlight(Flight flight) throws RouteNotFoundException{
        Map<String, Boolean> possibleArrivalAirports = mapCreator();

        boolean noRoute = true;

        for(Map.Entry<String, Boolean> entry : possibleArrivalAirports.entrySet()){
            if(entry.getKey().equals(flight.getArrivalAirport())){
                String s = "Is flight from " + flight.getDepartureAirport() + " to " + entry.getKey() + " possible: " + (entry.getValue() ? "YES" : "NO");
                System.out.println(s);
                noRoute = false;
            }
        }
        if(noRoute){
            throw new RouteNotFoundException("There's no Arrival Airport such " + flight.getArrivalAirport());
        }

    }
}
