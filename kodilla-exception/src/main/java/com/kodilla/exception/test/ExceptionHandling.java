package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();
        String result;
        try {
            result = secondChallenge.probablyIWillThrowException(0, 2);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("You entered wrong values");
        } finally {
            System.out.println("And that was the SecondChallenge");
        }
    }
}
