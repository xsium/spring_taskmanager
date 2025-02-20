package com.tyrfing.taskmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyrfing.taskmanager.exception.UserFoundException;
import com.tyrfing.taskmanager.exception.UserNotFoundException;
import com.tyrfing.taskmanager.model.User;
import com.tyrfing.taskmanager.repository.UserRepository;

import lombok.Data;

@Data
@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> getAllUsers() {
        return (List<User>) repo.findAll();
    }

    public User getUserById(Long id) {
        return repo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public User addUser(User user) {
        Optional<User> usertest = Optional.ofNullable(repo.findByEmail(user.getEmail()));
        if (usertest.isPresent()) {
            throw new UserFoundException(user);
        }
        return repo.save(user);
    }

}
