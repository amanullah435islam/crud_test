package com.example.dto.request;

import com.example.enums.Gender;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientRequest {

	@Schema(
			description = "Patient full name",
			example = "Aman"
	)
	private String name;



	@Schema(
			description = "Gender",
			example = "Male"
	)
	private Gender gender;



	@Schema(
			description = "Address",
			example = "Dhaka"
	)
	private String address;



	@Schema(
			description = "Patient age",
			example = "35"
	)
	private Long age;



	@Schema(
			description = "Description",
			example = "description.................."
	)
	private String description;

}
