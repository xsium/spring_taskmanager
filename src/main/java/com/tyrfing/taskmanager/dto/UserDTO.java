package com.tyrfing.taskmanager.dto;

import java.util.List;

public record UserDTO(
                String lastname,
                String firstname,
                String email,
                List<Task2DTO> tasks) {
}
