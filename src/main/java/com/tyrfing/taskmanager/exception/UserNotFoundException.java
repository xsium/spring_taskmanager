package com.tyrfing.taskmanager.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("User with ID: " + id + " does not exist.");
    }
}
