package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task {

    private final String taskName;
    private final String whatToBuy;
    private final double quantity;
    private boolean isTaskExecuted;

    public ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
        this.isTaskExecuted = false;
    }

    @Override
    public void executeTask() {
        this.isTaskExecuted = true;
    }

    @Override
    public String getTaskName() {
        return this.taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return this.isTaskExecuted;
    }
}
