package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigMacTestSuite {

    @Test
    void testBigMacBuilder() {
        //Given
        BigMac bigMac = new BigMac.BigmacBuilder()
                .bun(Bun.WITHOUT_SEZAM)
                .burgers(2)
                .sauce(Sauce.BARBECUE)
                .ingredients(Ingredients.SALAD)
                .ingredients(Ingredients.PICKLES)
                .build();
        System.out.println(bigMac);

        //When
        int numberOfBurgers = bigMac.getBurgers();

        //Then
        assertEquals(Bun.class, bigMac.getBun().getClass());
        assertEquals(2, numberOfBurgers);
        assertEquals(Sauce.class, bigMac.getSauce().getClass());
        assertEquals(2, bigMac.getIngredients().size());
    }
}
