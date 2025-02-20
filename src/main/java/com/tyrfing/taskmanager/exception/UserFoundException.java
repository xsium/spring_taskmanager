package com.tyrfing.taskmanager.exception;

import com.tyrfing.taskmanager.model.User;

public class UserFoundException extends RuntimeException {
    public UserFoundException(User user) {
        super("user: " + user.getFirstname() + " " + user.getLastname() + "is already registered.");
    }
}
