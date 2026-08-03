package com.example.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor
public class DoctorRegistrationDTO {

//	/ User information

	@Schema(
			description = "Doctor full name",
			example = "Dr. Aman"
	)
	private String name;


	@Schema(
			description = "Doctor email address",
			example = "doctor@gmail.com"
	)
	private String email;

	@Schema(
			description = "Contact phone number",
			example = "01712345678"
	)
	private String phone;


	@Schema(
			description = "Account password",
			example = "12345678",
			minLength = 6
	)
	private String password;




	
	// Doctor information

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
