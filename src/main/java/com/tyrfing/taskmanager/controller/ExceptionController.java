package com.tyrfing.taskmanager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tyrfing.taskmanager.exception.TaskNotFoundException;
import com.tyrfing.taskmanager.exception.UserFoundException;
import com.tyrfing.taskmanager.exception.UserNotFoundException;

@RestControllerAdvice
public class ExceptionController extends RuntimeException {
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String userNotFound(UserNotFoundException e) {
        return e.getMessage();
    }

    @ExceptionHandler(UserFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String userFound(UserFoundException e) {
        return e.getMessage();
    }

    @ExceptionHandler(TaskNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String taskNotFound(TaskNotFoundException e) {
        return e.getMessage();
    }

}
