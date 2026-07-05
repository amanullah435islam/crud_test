package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.User;
import com.example.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	

	@PostMapping("/save")
	public User save(User user) {
		return service.Create(user);
	}
	
	@GetMapping("/get")
	public List<User> Get() {
		return service.Get();
	}
}
