package com.tyrfing.taskmanager.dto;

import java.sql.Date;
import java.util.List;

public record TaskDTO(
                Long id,
                String title,
                String description,
                Date date,
                Boolean status,
                List<String> categories) {
}