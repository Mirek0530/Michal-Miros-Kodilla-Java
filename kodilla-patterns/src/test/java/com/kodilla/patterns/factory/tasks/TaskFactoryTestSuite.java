package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    TaskFactory taskFactory;

    @BeforeEach
    public void beforeEach() {
        taskFactory = new TaskFactory();
    }

    @Test
    void testTaskFactoryCreatingDrivingTask() {
        //Given

        //When
        Task driving = taskFactory.createTask(TaskFactory.DRIVING);

        //Then
        assertEquals("Food delivery", driving.getTaskName());
        assertFalse(driving.isTaskExecuted());
    }

    @Test
    void testTaskFactoryCreatingPaintingTask() {
        //Given

        //When
        Task painting = taskFactory.createTask(TaskFactory.PAINTING);
        painting.executeTask();

        //Then
        assertEquals("Paint some dead nature", painting.getTaskName());
        assertTrue(painting.isTaskExecuted());
    }

    @Test
    void testTaskFactoryCreatingShoppingTask() {
        //Given

        //When
        Task shopping = taskFactory.createTask(TaskFactory.SHOPPING);

        //Then
        assertEquals("Go to grocery store", shopping.getTaskName());
        assertFalse(shopping.isTaskExecuted());
    }
}
