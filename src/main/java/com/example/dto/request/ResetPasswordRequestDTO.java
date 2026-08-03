package com.example.dto.request;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ResetPasswordRequestDTO {

    @Schema(
            description = "token",
            example = "eyJhbGciOiJIUzI1NiJ9"
    )
    private String token;        // from email link

    @Schema(
            description = "New Password",
            example = "new1234"
    )
    private String newPassword;

}