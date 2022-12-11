package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    void testCalculations() {
        //Given

        //When
        double addResult = calculator.add(8,4);
        double subResult = calculator.sub(8,4);
        double mulResult = calculator.mul(8,4);
        double divResult = calculator.div(8,4);

        //Then
        assertEquals(12, addResult);
        assertEquals(4, subResult);
        assertEquals(32, mulResult);
        assertEquals(2, divResult);
    }

}
