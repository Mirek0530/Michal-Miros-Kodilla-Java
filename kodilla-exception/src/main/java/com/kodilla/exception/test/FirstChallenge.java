package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a/b;
    }

    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();
        double result;
        try {
            result = firstChallenge.divide(3, 0);
            System.out.println(result);
        } catch (ArithmeticException ae) {
            System.out.println("You can't divide by ZERO! Exception: " + ae);
        }
    }
}
