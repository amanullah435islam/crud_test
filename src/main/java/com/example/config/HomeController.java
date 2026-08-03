package com.example.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//"Swagger/OpenAPI" testing purpose use this class
public class HomeController {

    //@GetMapping("/")
    public String home() {
        return "Backend API Server Running Successfully";
    }
}
