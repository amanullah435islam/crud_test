package com.example.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ForgotPasswordRequestDTO {


    @Schema(
            description = "Doctor email address",
            example = "doctor@gmail.com"
    )
    private String email;

}