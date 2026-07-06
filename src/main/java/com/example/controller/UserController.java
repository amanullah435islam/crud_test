package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.User;
import com.example.response.UserRequest;
import com.example.response.UserResponse;
import com.example.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<UserResponse> save(@RequestBody UserRequest request) {
        UserResponse response = service.create(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get")
    public ResponseEntity<List<UserResponse>> getAll() {
        List<UserResponse> responses = service.getAll();
        return ResponseEntity.ok(responses);
    }
}



//						Complete Flow
//						
//						ধরি Client Postman থেকে Request পাঠালো
//						
//						POST
//						
//						/api/user/save
//						
//						Body
//						
//						{
//						   "name":"Aman",
//						   "password":"123456"
//						}
//						
//						↓
//						
//						Spring
//						
//						↓
//						
//						@RequestBody
//						
//						↓
//						
//						UserRequest
//						
//						↓
//						
//						Controller
//						
//						↓
//						
//						Service
//						
//						↓
//						
//						Entity
//						
//						User
//						
//						↓
//						
//						Repository
//						
//						↓
//						
//						Database
//						
//						↓
//						
//						Saved User
//						
//						↓
//						
//						UserResponse
//						
//						↓
//						
//						Controller
//						
//						↓
//						
//						ResponseEntity
//						
//						↓
//						
//						Client



//			GET /api/user/get
//			│
//			▼
//			Controller
//			│
//			▼
//			service.getAll()
//			│
//			▼
//			Repository.findAll()
//			│
//			▼
//			Database
//			│
//			▼
//			List<User>
//			│
//			▼
//			Convert User → UserResponse
//			│
//			▼
//			List<UserResponse>
//			│
//			▼
//			ResponseEntity.ok(...)
//			│
//			▼
//			HTTP 200 OK + JSON Response









