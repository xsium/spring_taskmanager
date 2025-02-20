package com.tyrfing.taskmanager.exception;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(Long id) {
        super("Task with ID: " + id + " does not exist.");
    }
}