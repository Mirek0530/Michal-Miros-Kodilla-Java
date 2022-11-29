package com.kodilla.good.patterns.challenges;

public class Main {
    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();

        String titles = movieStore.getMovies().entrySet().stream()
                .flatMap(n -> n.getValue().stream())
                .reduce("!", (sum, current) -> sum + current + "!");

        System.out.println(titles);
    }
}
