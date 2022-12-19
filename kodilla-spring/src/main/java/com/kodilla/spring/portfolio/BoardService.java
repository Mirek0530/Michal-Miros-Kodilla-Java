package com.kodilla.spring.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardRepository repository;

    public BoardService(BoardRepository boardRepository) {
        this.repository = boardRepository;
    }

    public void addTaskList(TaskList taskList) {
        repository.add(taskList);
    }

    public boolean addTask(String task, TaskList taskList) {
        return repository.addTask(task, taskList);
    }

    public boolean removeTask(String task, TaskList taskList) {
        return repository.removeTask(task, taskList);
    }

    public List<TaskList> getTaskLists() {
        return repository.getTaskLists();
    }
}
