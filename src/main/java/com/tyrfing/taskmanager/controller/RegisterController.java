package com.tyrfing.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RestController;

import com.tyrfing.taskmanager.model.AuthRequest;
import com.tyrfing.taskmanager.model.User;
import com.tyrfing.taskmanager.service.JWTService;
import com.tyrfing.taskmanager.service.UserServiceAuth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class RegisterController {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private UserServiceAuth userServiceAuth;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<String> connection(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            String token = jwtService.generateToken(authentication);
            return ResponseEntity.ok(token);
        } else {
            throw new UsernameNotFoundException("Invalid user request");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User userInfo) {
        String response = userServiceAuth.addUser(userInfo);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
