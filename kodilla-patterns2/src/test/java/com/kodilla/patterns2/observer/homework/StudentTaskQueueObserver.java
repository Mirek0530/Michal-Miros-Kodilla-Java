package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTaskQueueObserver {

    @Test
    void testStudentTaskQueueObserver() {
        //Given
        StudentTasksQueue mikaTasks = new StudentTasksQueue("Mika Rileey");
        StudentTasksQueue rodneyTasks = new StudentTasksQueue("Rodney Richards");
        StudentTasksQueue maxTasks = new StudentTasksQueue("Max Carter");

        Mentor adrianThompson = new Mentor("Adrian Thompson");
        Mentor mariaStewart = new Mentor("Maria Stewart");

        mikaTasks.registerObserver(adrianThompson);
        rodneyTasks.registerObserver(mariaStewart);
        maxTasks.registerObserver(adrianThompson);

        //When
        mikaTasks.addTask("Decimal to binary converter created");
        rodneyTasks.addTask("Code refactor");
        maxTasks.addTask("Tests implemented");

        //Then
        assertEquals(2, adrianThompson.getCounter());
        assertEquals(1, mariaStewart.getCounter());

    }
}
