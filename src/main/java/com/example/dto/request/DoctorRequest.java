package com.example.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorRequest {

	@Schema(
			description = "Doctor full name",
			example = "Dr. Aman"
	)
	private String name;


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