package com.fakestore.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fakestore.store.entity.User;
import com.fakestore.store.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	public User addUser(User user) {
		return userRepository.save(user);
	}
	public String login(User user) {
		System.out.println("Service method login "+user.getUsername());
		User userDb=userRepository.findByUsername(user.getUsername());
		System.out.println("user found");
		if(userDb==null)
			return "no user";
		
		if(userDb.getPassword().equals(user.getPassword()))
			return "success";
		else
			return "not success";
		
		
	}

}
