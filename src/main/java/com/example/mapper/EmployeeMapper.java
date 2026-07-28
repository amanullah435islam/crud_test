package com.example.mapper;

import com.example.dto.request.EmployeeRequest;
import com.example.dto.response.EmployeeResponse;
import com.example.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public Employee toEntity(EmployeeRequest request) {

        Employee employee = new Employee();

        employee.setName(request.getName());
        employee.setAddress(request.getAddress());
        employee.setCity(request.getCity());
        employee.setState(request.getState());
        employee.setZipCode(request.getZipCode());
        employee.setCountry(request.getCountry());

        return employee;
    }

    public EmployeeResponse toResponse(Employee employee) {

        return new EmployeeResponse(
                employee.getId(),
                employee.getName(),
                employee.getAddress(),
                employee.getCity(),
                employee.getState(),
                employee.getZipCode(),
                employee.getCountry()
        );
    }



    public void updateEntity(
            EmployeeRequest request,
            Employee employee) {

        if (request.getName() != null) {
            employee.setName(request.getName());
        }

        if (request.getAddress() != null) {
            employee.setAddress(request.getAddress());
        }

        if (request.getCity() != null) {
            employee.setCity(request.getCity());
        }

        if (request.getState() != null) {
            employee.setState(request.getState());
        }

        if (request.getZipCode() != null) {
            employee.setZipCode(request.getZipCode());
        }

        if (request.getCountry() != null) {
            employee.setCountry(request.getCountry());
        }
    }
}
