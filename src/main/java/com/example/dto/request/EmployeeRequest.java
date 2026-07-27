package com.example.dto.request;

import lombok.Data;

@Data
public class EmployeeRequest {
    private String name;


    private String address;

    private String city;

    private String state;

    private String zipCode;

    private String country;
}
