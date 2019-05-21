package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public final class Continent{
    private final List<Country> countries = new ArrayList<>();

    public void addCountry(Country country){
        this.countries.add(country);
    }

    public boolean removeCountry(Country country){
        return this.countries.remove(country);
    }

    public List<Country> getCountries(){
        return countries;
    }

}
