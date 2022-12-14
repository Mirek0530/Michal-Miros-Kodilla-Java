package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardTestSuite {

    @Autowired
    Board board;

    @Test
    void testTaskAdd() {
        //Given

        //When
        board.addTaskToDoList("Read book");
        board.addTaskInProgressList("Refactor your code");
        board.addTaskDoneList("Eat dinner");

        //Then
        System.out.println("To do list: " + board.getToDoList());
        System.out.println("In progress list: " + board.getInProgressList());
        System.out.println("Done list: " + board.getDoneList());

    }
}
