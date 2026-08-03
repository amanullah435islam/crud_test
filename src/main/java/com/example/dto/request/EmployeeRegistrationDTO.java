package com.example.dto.request;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class EmployeeRegistrationDTO {

//	/ User information

    @NotBlank(message="Name is required")
    @Schema(
            description = "Employee full name",
            example = "Aman"
    )
    private String name;


    @Email(message="Invalid email")
    @NotBlank(message="Email is required")
    @Schema(
            description = "Employee email address",
            example = "employee@gmail.com"
    )
    private String email;


    @Size(
            min=11,
            message="Phone number minimum 11 characters"
    )
    @Schema(
            description = "Contact phone number",
            example = "01712345678"
    )
    private String phone;


    @Size(
            min=6,
            message="Password minimum 6 characters"
    )
    @Schema(
            description = "Account password",
            example = "12345678",
            minLength = 6
    )
    private String password;





//	/ Employee information

    @Schema(
            description = "Please find your Address",
            example = "Dhaka"
    )
    private String address;

    @Schema(
            description = "Please find your City",
            example = "Dhaka"
    )
    private String city;

    @Schema(
            description = "Please find your State",
            example = "Dhaka"
    )
    private String state;


    @Schema(
            description = "Please find your Zip Code",
            example = "1200"
    )
    private String zipCode;

    @Schema(
            description = "Please find your Country",
            example = "Bangladesh"
    )
    private String country;

}
