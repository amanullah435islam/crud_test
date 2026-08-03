package com.example.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class EmployeeRequest {

    @Schema(
            description = "Doctor full name",
            example = "Dr. Aman"
    )
    private String name;


    @Schema(
            description = "Please find your Address",
            example = "Dhaka"
    )
    private String address;

    @Schema(
            description = "Please find your City",
            example = "Dhaka"
    )
    private String city;

    @Schema(
            description = "Please find your State",
            example = "Dhaka"
    )
    private String state;


    @Schema(
            description = "Please find your Zip Code",
            example = "1200"
    )
    private String zipCode;

    @Schema(
            description = "Please find your Country",
            example = "Bangladesh"
    )
    private String country;

}
