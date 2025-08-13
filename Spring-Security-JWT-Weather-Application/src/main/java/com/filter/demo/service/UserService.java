package com.filter.demo.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.filter.demo.entity.RegisterUserRequest;
import com.filter.demo.entity.UserResponse;
import com.filter.demo.entity.Users;
import com.filter.demo.repository.UserDetailsRepository;

@Service
public class UserService {

    private final UserDetailsRepository userDetailsRepository;
    private final PasswordEncoder passwordEncoder;
    
    public UserService(UserDetailsRepository userDetailsRepository, PasswordEncoder passwordEncoder) {
        this.userDetailsRepository = userDetailsRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse registerUser(RegisterUserRequest registerUserRequest){
        if(userDetailsRepository.findByUsername(registerUserRequest.getUsername()).isPresent()){
            throw new RuntimeException("User Already Exist");
        }
        Users users = new Users();
        users.setUsername(registerUserRequest.getUsername());
        users.setRole(registerUserRequest.getRole());
        users.setPassword(passwordEncoder.encode(registerUserRequest.getPassword()));
        Users savedUser = userDetailsRepository.save(users);
        return new UserResponse(savedUser.getId(), savedUser.getUsername(),savedUser.getRole().name());
    }
}