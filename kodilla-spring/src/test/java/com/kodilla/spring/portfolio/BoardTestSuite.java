package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class BoardTestSuite {

    @Test
    void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

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
