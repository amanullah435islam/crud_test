package com.example.dto.response;

public class UserResponse {
    
	private Long id;
    private String name;
    private String userName;
    
    
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public UserResponse() {
		super();
	}
	
	public UserResponse(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	
	public UserResponse(Long id, String name, String userName) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
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
    
}
