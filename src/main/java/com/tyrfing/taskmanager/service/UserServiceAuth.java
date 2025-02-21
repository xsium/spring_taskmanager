package com.tyrfing.taskmanager.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tyrfing.taskmanager.model.User;
import com.tyrfing.taskmanager.repository.UserRepository;

import java.util.Optional;

@Service
public class UserServiceAuth implements UserDetailsService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserServiceAuth(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    // Méthode pour récupérer le compte qui va se connecte
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userDetail = Optional.ofNullable(repository.findByEmail(email));
        return userDetail.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + email));
    }

    // Méthode pour ajouter un compte en BDD
    public String addUser(User userInfo) {
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "User Added Successfully";
    }
}