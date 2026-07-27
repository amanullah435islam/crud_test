package com.example.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorResponse {
	
	    private Long id;
	    private String name;
	    private String age;
	    private String designation;
	    private double salary;

	}

