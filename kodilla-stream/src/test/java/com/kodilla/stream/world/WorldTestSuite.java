package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite{
    @Test
    public void testGetPeopleQuantity(){
        //Given
        //Creating World
        World world = new World();

        //Creating Continents
        Continent continent1 = new Continent();
        Continent continent2 = new Continent();
        Continent continent3 = new Continent();
        Continent continent4 = new Continent();
        Continent continent5 = new Continent();
        Continent continent6 = new Continent();
        Continent continent7 = new Continent();

        //Creating Countries with theirs People Quantity
        Country country11 = new Country(new BigDecimal("11111111111111111111"));
        Country country12 = new Country(new BigDecimal("22222222222222222222"));
        Country country13 = new Country(new BigDecimal("33333333333333333333"));
        Country country14 = new Country(new BigDecimal("44444444444444444444"));
        Country country15 = new Country(new BigDecimal("55555555555555555555"));
        Country country21 = new Country(new BigDecimal("66666666666666666666"));
        Country country22 = new Country(new BigDecimal("77777777777777777777"));
        Country country23 = new Country(new BigDecimal("88888888888888888888"));
        Country country24 = new Country(new BigDecimal("99999999999999999999"));
        Country country25 = new Country(new BigDecimal("11111111111111111111"));
        Country country31 = new Country(new BigDecimal("22222222222222222222"));
        Country country32 = new Country(new BigDecimal("33333333333333333333"));
        Country country33 = new Country(new BigDecimal("44444444444444444444"));
        Country country34 = new Country(new BigDecimal("55555555555555555555"));
        Country country35 = new Country(new BigDecimal("66666666666666666666"));
        Country country41 = new Country(new BigDecimal("77777777777777777777"));
        Country country42 = new Country(new BigDecimal("88888888888888888888"));
        Country country43 = new Country(new BigDecimal("99999999999999999999"));
        Country country44 = new Country(new BigDecimal("11111111111111111111"));
        Country country45 = new Country(new BigDecimal("22222222222222222222"));
        Country country51 = new Country(new BigDecimal("33333333333333333333"));
        Country country52 = new Country(new BigDecimal("44444444444444444444"));
        Country country53 = new Country(new BigDecimal("55555555555555555555"));
        Country country54 = new Country(new BigDecimal("66666666666666666666"));
        Country country55 = new Country(new BigDecimal("77777777777777777777"));
        Country country56 = new Country(new BigDecimal("88888888888888888888"));
        Country country57 = new Country(new BigDecimal("99999999999999999999"));
        Country country61 = new Country(new BigDecimal("11111111111111111111"));
        Country country62 = new Country(new BigDecimal("22222222222222222222"));
        Country country63 = new Country(new BigDecimal("33333333333333333333"));
        Country country64 = new Country(new BigDecimal("44444444444444444444"));
        Country country65 = new Country(new BigDecimal("55555555555555555555"));
        Country country66 = new Country(new BigDecimal("66666666666666666666"));
        Country country67 = new Country(new BigDecimal("77777777777777777777"));
        Country country68 = new Country(new BigDecimal("88888888888888888888"));
        Country country69 = new Country(new BigDecimal("99999999999999999999"));
        Country country71 = new Country(new BigDecimal("11111111111111111111"));
        Country country72 = new Country(new BigDecimal("22222222222222222222"));
        Country country73 = new Country(new BigDecimal("88888888888888888888"));
        Country country74 = new Country(new BigDecimal("99999999999999999999"));

        //Adding Countries to Continents
        continent1.addCountry(country11);
        continent1.addCountry(country12);
        continent1.addCountry(country13);
        continent1.addCountry(country14);
        continent1.addCountry(country15);
        continent2.addCountry(country21);
        continent2.addCountry(country22);
        continent2.addCountry(country23);
        continent2.addCountry(country24);
        continent2.addCountry(country25);
        continent3.addCountry(country31);
        continent3.addCountry(country32);
        continent3.addCountry(country33);
        continent3.addCountry(country34);
        continent3.addCountry(country35);
        continent4.addCountry(country41);
        continent4.addCountry(country42);
        continent4.addCountry(country43);
        continent4.addCountry(country44);
        continent4.addCountry(country45);
        continent5.addCountry(country51);
        continent5.addCountry(country52);
        continent5.addCountry(country53);
        continent5.addCountry(country54);
        continent5.addCountry(country55);
        continent5.addCountry(country56);
        continent5.addCountry(country57);
        continent6.addCountry(country61);
        continent6.addCountry(country62);
        continent6.addCountry(country63);
        continent6.addCountry(country64);
        continent6.addCountry(country65);
        continent6.addCountry(country66);
        continent6.addCountry(country67);
        continent6.addCountry(country68);
        continent6.addCountry(country69);
        continent7.addCountry(country71);
        continent7.addCountry(country72);
        continent7.addCountry(country73);
        continent7.addCountry(country74);

        //Adding Continents to the World
        world.addContinent(continent1);
        world.addContinent(continent2);
        world.addContinent(continent3);
        world.addContinent(continent4);
        world.addContinent(continent5);
        world.addContinent(continent6);
        world.addContinent(continent7);

        //When
        BigDecimal returnedPeopleInTheWorld = world.getPeopleQuantity();

        //Then
        BigDecimal expectedPeoplrInTheWorld = new BigDecimal("2222222222222222222200");

        Assert.assertEquals(expectedPeoplrInTheWorld, returnedPeopleInTheWorld);
    }
}
