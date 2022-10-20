package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;


public class StreamMain {
    public static void main(String[] args) {
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        //
        PoemBeautifier pb = new PoemBeautifier();

        pb.beautify("First text to beautify", (stringToBeautify) -> System.out.println("ABC" + stringToBeautify + "ABC"));
        pb.beautify("Second text to beautify", (stringToBeautify) -> System.out.println(stringToBeautify.toUpperCase()));
        pb.beautify("Third text to beautify", (stringToBeautify) -> System.out.println("!---" + stringToBeautify + "---!"));
        pb.beautify("Fourth text to beautify", (stringToBeautify) -> System.out.println("I_i_._" + stringToBeautify + "_._i_I"));

        System.out.println("Using stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}
