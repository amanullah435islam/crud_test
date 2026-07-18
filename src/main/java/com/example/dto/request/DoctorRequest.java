package com.example.dto.request;

public class DoctorRequest {
	
	    private String name;
	    private String age;
	    private String designation;
	    private double salary;

	    // Default Constructor
	    public DoctorRequest() {
	    }

	    // All Arguments Constructor
	    public DoctorRequest(String name, String age, String designation, double salary) {
	        this.name = name;
	        this.age = age;
	        this.designation = designation;
	        this.salary = salary;
	    }

	    // Getters and Setters
	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }

	    public String getAge() { return age; }
	    public void setAge(String age) { this.age = age; }

	    public String getDesignation() { return designation; }
	    public void setDesignation(String designation) { this.designation = designation; }

	    public double getSalary() { return salary; }
	    public void setSalary(double salary) { this.salary = salary; }
	}

