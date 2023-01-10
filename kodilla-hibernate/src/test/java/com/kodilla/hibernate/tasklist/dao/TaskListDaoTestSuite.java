package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    TaskListDao tld;

    @Test
    void testFindByListName() {
        //Given
        TaskList taskList = new TaskList("To Do List", "Things to do");

        //When
        tld.save(taskList);

        //Then
        int id = taskList.getId();
        List<TaskList> readTaskList = tld.findByListName("To Do List");
        assertEquals(1, readTaskList.size());

        //CleanUp
        tld.deleteById(id);
    }
}
