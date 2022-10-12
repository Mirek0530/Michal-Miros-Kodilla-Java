package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int addictionResult = calculator.add(192,8);

        if (addictionResult == 200) {
            System.out.println("test OK");
        } else {
            System.out.println("ERROR!");
        }

        int subtractionResult = calculator.subtract(56,27);

        if (subtractionResult == 29) {
            System.out.println("test OK");
        } else {
            System.out.println("ERROR!");
        }
    }
}
