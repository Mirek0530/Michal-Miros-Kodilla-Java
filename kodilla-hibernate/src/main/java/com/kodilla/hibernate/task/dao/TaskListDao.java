package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.TaskList;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface TaskListDao extends CrudRepository<TaskList, Integer> {

}
