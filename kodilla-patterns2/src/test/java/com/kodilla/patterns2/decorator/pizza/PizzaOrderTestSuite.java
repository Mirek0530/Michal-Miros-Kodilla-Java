package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    void testBasicPizzaOrderGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();

        //When
        BigDecimal cost = pizzaOrder.getCost();

        //Then
        assertEquals(new BigDecimal(15.00), cost);
    }

    @Test
    void testBasicPizzaOrderGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();

        //When
        String description = pizzaOrder.getDescription();

        //Then
        assertEquals("Pizza with tomato sauce and cheese", description);
    }

    @Test
    void testPizzaOrderWithExtraCheeseAndMushroomsGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);
        pizzaOrder = new MushroomsDecorator(pizzaOrder);
        System.out.println(pizzaOrder.getCost());

        //When
        BigDecimal cost = pizzaOrder.getCost();

        //Then
        assertEquals(new BigDecimal(20), cost);
    }

    @Test
    void testPizzaOrderWithExtraCheeseAndMushroomsGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);
        pizzaOrder = new MushroomsDecorator(pizzaOrder);
        System.out.println(pizzaOrder.getDescription());

        //When
        String description = pizzaOrder.getDescription();

        //Then
        assertEquals("Pizza with tomato sauce and cheese + extra cheese + mushrooms", description);
    }

    @Test
    void testPizzaOrderWithHamAndPineappleGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new PineappleDecorator(pizzaOrder);
        System.out.println(pizzaOrder.getCost());

        //When
        BigDecimal cost = pizzaOrder.getCost();

        //Then
        assertEquals(new BigDecimal(24), cost);
    }

    @Test
    void testPizzaOrderWithHamAndPineappleGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new PineappleDecorator(pizzaOrder);
        System.out.println(pizzaOrder.getDescription());

        //When
        String description = pizzaOrder.getDescription();

        //Then
        assertEquals("Pizza with tomato sauce and cheese + ham + pineapple", description);
    }

}
