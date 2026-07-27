package com.example.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {

    private long id;

    private String name;


    private String address;

    private String city;

    private String state;

    private String zipCode;

    private String country;
}
