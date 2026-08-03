package com.example.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginRequestDTO {

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    @Schema(
            description = "User email address",
            example = "aman@gmail.com",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String email;



    @NotBlank(message = "Password is required")
    @Size(
            min = 6,
            message = "Password must contain minimum 6 characters"
    )
    @Schema(
            description = "User password",
            example = "12345678",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String password;

}
