package com.example.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class LoginRequestDTO {

    @Schema(
            description = "User email address",
            example = "user@gmail.com"
    )
    private String email;


    @Schema(
            description = "Account password",
            example = "12345678",
            minLength = 6
    )
    private String password;

}
