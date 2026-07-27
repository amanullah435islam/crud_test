package com.example.dto.request;


import lombok.Data;


@Data
public class EmployeeRegistrationDTO {

//	/ User information

    private String name;

    private String email;

    private String phone;

    private String password;



//	/ Employee information

    private String address;

    private String city;

    private String state;

    private String zipCode;

    private String country;

}
