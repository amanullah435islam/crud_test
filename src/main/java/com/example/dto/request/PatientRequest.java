package com.example.dto.request;

import com.example.enums.Gender;


public class PatientRequest {


	private String name;
	
	private Gender gender;
	
	private String address;
	
	private Long age;

	private String description;
	
	
	public PatientRequest() {
		super();
	}
	
	
	

	public PatientRequest(String name, Gender gender, String address, Long age, String description) {

		this.name = name;
		this.gender = gender;
		this.address = address;
		this.age = age;
		this.description = description;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
