package com.kodilla.patterns2.observer.homework;

public class Mentor implements HomeworkObserver {
    private final String name;
    private int counter;

    public Mentor(String name) {
        this.name = name;
        counter = 0;
    }

    @Override
    public void update(StudentTasksQueue studentTasksQueue) {
        System.out.println(name + ": New homework task added in " + studentTasksQueue.getStudentName());
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}
