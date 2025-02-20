package com.tyrfing.taskmanager.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyrfing.taskmanager.dto.TaskDTO;
import com.tyrfing.taskmanager.model.Task;
import com.tyrfing.taskmanager.repository.TaskRepository;
import lombok.Data;

@Data
@Service
public class TaskService {

    @Autowired
    private TaskRepository repo;
    @Autowired
    private TaskDTOWrapper taskDTOWrapper;

    public List<TaskDTO> getAllTasks() {
        return ((List<Task>) repo.findAll()).stream().map(taskDTOWrapper::toDto).collect(Collectors.toList());
    }

    public Stream<TaskDTO> getTaskById(Long id) {
        return repo.findById(id).stream().map(taskDTOWrapper::toDto);
    }

    public Task addTask(Task task) {
        return repo.save(task);
    }

}
