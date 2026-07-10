package com.example.response;

public class DoctorRegistrationRequest {
    // Auth Data
    private String username;
    private String password;
    
    // Profile Data
    private String name;
    private String age;
    private String designation;
    private double salary;
    
    
	public DoctorRegistrationRequest() {
		super();
	}

	
	public DoctorRegistrationRequest(String username, String password, String name, String age, String designation,
			double salary) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.age = age;
		this.designation = designation;
		this.salary = salary;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}

	
	
    // Default & Field Constructors, Getters & Setters generate kore niben.
    
    
    
    
}
