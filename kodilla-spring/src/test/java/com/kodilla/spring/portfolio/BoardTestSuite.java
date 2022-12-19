package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BoardTestSuite {

    @Autowired
    BoardService boardService;

    TaskList myList, mondayTasks, doneTasks, otherList;

    @BeforeEach
    public void beforeEach() {
        myList = new TaskList("My list");
        mondayTasks = new TaskList("Monday tasks");
        doneTasks = new TaskList("Done tasks");
        otherList = new TaskList("Other list");
    }

    @Test
    void testTaskAdd() {
        //Given
        boardService.addTaskList(mondayTasks);

        //When
        boolean resultAddTaskToExistingList = boardService.addTask("Be happy", mondayTasks);
        boolean resultAddTaskToNonExistingList = boardService.addTask("Go shopping", otherList);

        //Then
        assertTrue(resultAddTaskToExistingList);
        assertFalse(resultAddTaskToNonExistingList);
    }

    @Test
    void testTaskRemove() {
        //Given
        boardService.addTaskList(myList);
        boardService.addTask("Be happy", myList);

        //When
        boolean resultRemoveExistingTask = boardService.removeTask("Be happy", myList);
        boolean resultRemoveNonExistingTask = boardService.removeTask("Go shopping", myList);

        //Then
        assertTrue(resultRemoveExistingTask);
        assertFalse(resultRemoveNonExistingTask);
    }

    @Test
    void testTaskListAdd() {
        //Given

        //When
        boardService.addTaskList(doneTasks);

        //Then
        assertEquals(3, boardService.getTaskLists().size());
    }

}
