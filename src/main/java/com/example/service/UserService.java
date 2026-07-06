package com.example.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repo.UserRepo;
import com.example.response.UserRequest;
import com.example.response.UserResponse;

@Service
public class UserService {

	private final UserRepo repo;

    // Construction injection is preferred over @Autowired for modern Java 21 apps
    public UserService(UserRepo repo) {
        this.repo = repo;
    }

    public UserResponse create(UserRequest request) {
        // Convert Request DTO -> Database Entity
        User user = new User();
        user.setName(request.getName());
        user.setPassword(request.getPassword()); // Consider using jBcrypt here later!

        User savedUser = repo.save(user);

        // Convert Database Entity -> Response DTO
        
        //  //ata dile response null ase :
        //return new UserResponse();
        
        
        // //akane response patano hoi:
        return new UserResponse(
                savedUser.getId(),
                savedUser.getName()
        );
    }

    public List<UserResponse> getAll() {
        return repo.findAll().stream()
                .map(user -> new UserResponse(user.getId(), user.getName()))
                .collect(Collectors.toList());
    }
    
    
    public UserResponse getById(Long id) {
        User user = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        
        // Map Entity to safe Response DTO
        return new UserResponse(user.getId(), user.getName());
    }
    
    
    public UserResponse getById2(Long id) {
    	
    	User user = repo.findById(id)
    				.orElseThrow(() -> new RuntimeException("User not found with id: " + id));

    	return new UserResponse(user.getId(),user.getName());
    }
    
    
    
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Cannot delete. User not found with id: " + id);
        }
        repo.deleteById(id);
    }

	
	
}
