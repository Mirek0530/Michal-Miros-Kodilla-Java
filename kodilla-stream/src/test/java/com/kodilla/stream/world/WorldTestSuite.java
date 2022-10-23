package com.kodilla.stream.world;

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

        Country narnia = new Country(new BigDecimal("53412378"));
        Country iceville = new Country(new BigDecimal("658567423"));
        Country poland = new Country(new BigDecimal("534112"));
        Country holland = new Country(new BigDecimal("1432561"));
        Country greenpoint = new Country(new BigDecimal("325488456"));
        Country fiji = new Country(new BigDecimal("13435161"));
        Country aedirn = new Country(new BigDecimal("3426771"));
        Country samoa = new Country(new BigDecimal("324263735"));
        Country smallford = new Country(new BigDecimal("435737537"));
        Country finland = new Country(new BigDecimal("63462342"));
        Country oceanyard = new Country(new BigDecimal("42341237"));
        Country norway = new Country(new BigDecimal("123226537"));
        Country dimwater = new Country(new BigDecimal("123657553"));
        Country snowborough = new Country(new BigDecimal("123345"));
        Country sweden = new Country(new BigDecimal("32424123"));

        antlantis.addCountry(narnia);
        antlantis.addCountry(greenpoint);
        antlantis.addCountry(aedirn);
        antlantis.addCountry(dimwater);

        europe.addCountry(poland);
        europe.addCountry(holland);
        europe.addCountry(finland);
        europe.addCountry(norway);
        europe.addCountry(sweden);

        antarctic.addCountry(iceville);
        antarctic.addCountry(snowborough);

        oceania.addCountry(fiji);
        oceania.addCountry(samoa);
        oceania.addCountry(smallford);
        oceania.addCountry(oceanyard);

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
