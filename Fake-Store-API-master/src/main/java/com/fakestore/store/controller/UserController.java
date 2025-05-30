package com.fakestore.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fakestore.store.entity.User;
import com.fakestore.store.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	
	@PostMapping("/registerUser")
	public User addProduct(@RequestBody User user)
	{
		System.out.println("Received product: " + user.getUsername());
		return userService.addUser(user);
		//return "Product";
	}
	
	@PostMapping("/login")
	public String login(@RequestBody User user)
	{
		System.out.println("Request received: " + user.getUsername());
		return userService.login(user);
	}
}
