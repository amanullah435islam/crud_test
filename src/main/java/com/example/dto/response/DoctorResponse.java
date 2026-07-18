package com.example.dto.response;

public class DoctorResponse {
	
	    private Long id;
	    private String name;
	    private String age;
	    private String designation;
	    private double salary;

	    // Default Constructor
	    public DoctorResponse() {
	    }

	    // All Arguments Constructor
	    public DoctorResponse(Long id, String name, String age, String designation, double salary) {
	        this.id = id;
	        this.name = name;
	        this.age = age;
	        this.designation = designation;
	        this.salary = salary;
	    }

	    // Getters and Setters
	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }

	    public String getAge() { return age; }
	    public void setAge(String age) { this.age = age; }

	    public String getDesignation() { return designation; }
	    public void setDesignation(String designation) { this.designation = designation; }

	    public double getSalary() { return salary; }
	    public void setSalary(double salary) { this.salary = salary; }
	}

