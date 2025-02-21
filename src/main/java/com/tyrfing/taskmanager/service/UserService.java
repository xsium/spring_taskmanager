package com.tyrfing.taskmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyrfing.taskmanager.dto.UserDTO;
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

    @Autowired
    private UserDTOWrapper userDTOWrapper;

    public List<User> getAllUsers() {
        return (List<User>) repo.findAll();
    }

    public UserDTO getUserById(Long id) {
        User user = repo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return userDTOWrapper.toDto(user);
    }

    public User addUser(User user) {
        Optional<User> usertest = Optional.ofNullable(repo.findByEmail(user.getEmail()));
        if (usertest.isPresent()) {
            throw new UserFoundException(user);
        }
        return repo.save(user);
    }

    public UserDTO getUserByEmail(String email) {
        User user = repo.findByEmail(email);
        return userDTOWrapper.toDto(user);
    }

}
