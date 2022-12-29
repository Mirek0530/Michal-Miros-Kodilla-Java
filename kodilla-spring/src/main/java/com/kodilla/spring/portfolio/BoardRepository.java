package com.kodilla.spring.portfolio;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardRepository {

    private final List<TaskList> taskLists = new ArrayList<>();

    public List<TaskList> getTaskLists() {
        return taskLists;
    }

    public void add(TaskList taskList) {
        taskLists.add(taskList);
    }

    public boolean addTask(String task, TaskList taskList) {
        if (taskLists.contains(taskList)) {
            taskList.add(task);
            return true;
        }
        return false;
    }

    public boolean removeTask(String task, TaskList taskList) {
        if (taskLists.contains(taskList)) {
            if (taskList.isTaskExistingInTaskList(task)) {
                taskList.remove(task);
                return true;
            }
        }
        return false;
    }
}
