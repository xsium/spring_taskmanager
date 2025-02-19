package com.tyrfing.taskmanager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tyrfing.taskmanager.model.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

}
