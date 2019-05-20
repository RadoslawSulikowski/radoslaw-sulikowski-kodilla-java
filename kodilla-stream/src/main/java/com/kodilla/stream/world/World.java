package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class World{
    private final List<Continent> continents = new ArrayList<>();

    public void addContinent(Continent continent){
        this.continents.add(continent);
    }
    public boolean removeContinent(Continent continent){
        return this.continents.remove(continent);
    }

    public List<Continent> getContinents(){
        return continents;
    }
    public BigDecimal getPeopleQuantity(){
        BigDecimal peopleQuantity = continents.stream()
                .flatMap(continent -> continent.getCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO,(sum, current) -> sum = sum.add(current));

        return peopleQuantity;
    }
}
