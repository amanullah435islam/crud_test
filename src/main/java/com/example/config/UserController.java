package com.example.config;

import com.example.entity.User;
import com.example.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping()
public class UserController {

    private final UserService userService;



    @GetMapping("/{id}")
    @Operation(
            summary = "Get user by ID",
            description = "Fetch user information using user id"
    )
    @ApiResponses({

            @ApiResponse(
                    responseCode = "200",
                    description = "User found"
            ),

            @ApiResponse(
                    responseCode = "404",
                    description = "User not found"
            )

    })
    public Optional<User> getUser(@PathVariable Long id){

        return userService.getById(id);
    }
}
