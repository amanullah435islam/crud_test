package com.example.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor
public class DoctorRegistrationDTO {

//	/ User information

	private String name;

	private String email;

	private String phone;

	private String password;


	// Doctor information

	private String age;

	private String designation;

	private double salary;

}
