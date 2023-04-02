package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class StudentTasksQueue implements HomeworkObservable {
    private final String studentName;
    private final List<String> tasks;
    private final List<HomeworkObserver> homeworkObservers;

    public StudentTasksQueue(String studentName) {
        this.studentName = studentName;
        tasks = new ArrayList<>();
        homeworkObservers = new ArrayList<>();
    }

    public void addTask(String taskName) {
        tasks.add(taskName);
        notifyObservers();
    }

    @Override
    public void registerObserver(HomeworkObserver observer) {
        homeworkObservers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (HomeworkObserver observer : homeworkObservers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(HomeworkObserver observer) {
        homeworkObservers.remove(observer);
    }

    public List<String> getTasks() {
        return tasks;
    }

    public List<HomeworkObserver> getHomeworkObservers() {
        return homeworkObservers;
    }

    public String getStudentName() {
        return studentName;
    }
}
