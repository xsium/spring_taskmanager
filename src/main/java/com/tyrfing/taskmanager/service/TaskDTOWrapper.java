package com.tyrfing.taskmanager.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tyrfing.taskmanager.dto.TaskDTO;
import com.tyrfing.taskmanager.model.Task;

@Service
public class TaskDTOWrapper {
    public TaskDTO toDto(Task task) {
        return new TaskDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDate(),
                task.getStatus(),
                task.getCategories().stream().map(category -> category.getLabel()).collect(Collectors.toList()));
    }

    public List<TaskDTO> toDtoList(List<Task> tasks) {
        return tasks.stream().map(this::toDto).collect(Collectors.toList());
    }
}
