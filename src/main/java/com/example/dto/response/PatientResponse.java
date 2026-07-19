package com.example.dto.response;

import com.example.enums.Gender;



public class PatientResponse {

	private Long id;
	
	private String name;
	
	private Long age;
	
	private Gender gender;
	
	private String address;
	

	private String description;
	
	
	

	public PatientResponse() {
		super();
	}

	
	

	public PatientResponse(Long id, String name, Long age, Gender gender, String address, String description) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.description = description;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
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
