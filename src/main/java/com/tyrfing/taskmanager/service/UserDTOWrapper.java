package com.tyrfing.taskmanager.service;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tyrfing.taskmanager.dto.Task2DTO;
import com.tyrfing.taskmanager.dto.UserDTO;
import com.tyrfing.taskmanager.model.User;

@Service
public class UserDTOWrapper {
    public UserDTO toDto(User user) {
        return new UserDTO(
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                user.getTasks().stream().map(task -> new Task2DTO(task.getTitle(), task.getDate()))
                        .collect(Collectors.toList()));
    }
}
