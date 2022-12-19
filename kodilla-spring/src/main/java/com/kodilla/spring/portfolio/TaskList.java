package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TaskList {
    private final List<String> tasks;
    private final String name;

    public TaskList(String taskListName) {
        tasks = new ArrayList<>();
        name = taskListName;
    }

    public void add(String task) {
        tasks.add(task);
    }

    public boolean remove(String task) {
        if (tasks.contains(task)) {
            tasks.remove(task);
            return true;
        }
        return false;
    }

    public boolean isTaskExistingInTaskList(String task) {
        return tasks.contains(task);
    }

    @Override
    public String toString() {
        return name + "=" + tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskList taskList = (TaskList) o;
        return Objects.equals(tasks, taskList.tasks) && Objects.equals(name, taskList.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tasks, name);
    }
}
