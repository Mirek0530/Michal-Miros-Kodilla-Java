package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public Task createTask(final String taskClass) {
        return switch (taskClass) {
            case SHOPPING -> new ShoppingTask("Go to grocery store", "Buy eggs", 10);
            case PAINTING -> new PaintingTask("Paint some dead nature", "Yellow", "Bananas in basket");
            case DRIVING -> new DrivingTask("Food delivery", "Gdansk", "Bicycle");
            default -> null;
        };
    }
}
