package com.example.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String userName;
    
    private String password;

    
 // Bi-directional relationship (Optional, dependency maintenance logic-er jonno useful)
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Doctor doctor;
    
    public Doctor getDoctor() { return doctor; }
    
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }
    
    
    
	public User() {
		super();
	}


	public User(Long id, String name, String userName, String password, Doctor doctor) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.doctor = doctor;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
