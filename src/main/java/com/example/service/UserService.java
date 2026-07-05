package com.example.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;
	
	
	public User Create(User user) {
		return repo.save(user);
		
	}
	
	public List<User> Get() {
		return repo.findAll();
	}
	
	
}
