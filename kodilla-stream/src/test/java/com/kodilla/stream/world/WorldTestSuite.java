package com.kodilla.stream.world;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        //Given
        World earth = new World();

        Continent antlantis = new Continent();
        Continent europe = new Continent();
        Continent antarctic = new Continent();
        Continent oceania = new Continent();

        Country country1 = new Country(new BigDecimal("53412378"));
        Country country2 = new Country(new BigDecimal("658567423"));
        Country country3 = new Country(new BigDecimal("534112"));
        Country country4 = new Country(new BigDecimal("1432561"));
        Country country5 = new Country(new BigDecimal("325488456"));
        Country country6 = new Country(new BigDecimal("13435161"));
        Country country7 = new Country(new BigDecimal("3426771"));
        Country country8 = new Country(new BigDecimal("324263735"));
        Country country9 = new Country(new BigDecimal("435737537"));
        Country country10 = new Country(new BigDecimal("63462342"));
        Country country11 = new Country(new BigDecimal("42341237"));
        Country country12 = new Country(new BigDecimal("123226537"));
        Country country13 = new Country(new BigDecimal("123657553"));
        Country country14 = new Country(new BigDecimal("123345"));
        Country country15 = new Country(new BigDecimal("32424123"));

        antlantis.addCountry(country1);
        antlantis.addCountry(country5);
        antlantis.addCountry(country7);
        antlantis.addCountry(country13);

        europe.addCountry(country3);
        europe.addCountry(country4);
        europe.addCountry(country10);
        europe.addCountry(country12);
        europe.addCountry(country15);

        antarctic.addCountry(country2);
        antarctic.addCountry(country14);

        oceania.addCountry(country6);
        oceania.addCountry(country8);
        oceania.addCountry(country9);
        oceania.addCountry(country11);

        earth.addContinent(antlantis);
        earth.addContinent(europe);
        earth.addContinent(antarctic);
        earth.addContinent(oceania);

        //When
        BigDecimal resultQuantity = earth.getPeopleQuantity();

        //Then
        BigDecimal expectedResult = new BigDecimal("2201533271");
        assertEquals(expectedResult, resultQuantity);
    }
}
