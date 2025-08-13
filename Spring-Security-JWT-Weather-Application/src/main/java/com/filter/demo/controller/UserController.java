package com.filter.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filter.demo.entity.RegisterUserRequest;
import com.filter.demo.entity.Role;
import com.filter.demo.entity.UserResponse;
import com.filter.demo.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody RegisterUserRequest registerUserRequest){
        registerUserRequest.setRole(Role.USER);
        UserResponse userResponse = userService.registerUser(registerUserRequest);
        return ResponseEntity.ok(userResponse);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/admin/create")
    public ResponseEntity<UserResponse> registerByAdmin(@RequestBody RegisterUserRequest registerUserRequest){
        UserResponse userResponse = userService.registerUser(registerUserRequest);
        return ResponseEntity.ok(userResponse);
    }
}
