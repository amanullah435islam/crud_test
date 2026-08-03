package com.example.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor
public class DoctorRegistrationDTO {

//	/ User information
	@NotBlank(message="Name is required")
	@Schema(
			description = "Doctor full name",
			example = "Dr. Aman"
	)
	private String name;



	@Email(message="Invalid email")
	@NotBlank(message="Email is required")
	@Schema(
			description = "Doctor email address",
			example = "doctor@gmail.com"
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





	// Doctor information
	@Min(value = 18,
			message="Doctor age must be above 18")
	@Schema(
			description = "Doctor age",
			example = "35"
	)
	private Integer age;


	@Schema(
			description = "Doctor specialization/designation",
			example = "Cardiologist"
	)
	private String designation;


	@Schema(
			description = "Monthly salary",
			example = "50000"
	)
	private Double salary;
}
