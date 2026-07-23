package com.example.dto.response;

import lombok.Data;

@Data
public class RegisterResponseDTO {

    private String message;
    private String verificationToken;

}
