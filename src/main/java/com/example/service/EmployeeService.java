package com.example.service;

import com.example.dto.request.EmployeeRequest;
import com.example.dto.response.EmployeeResponse;
import com.example.entity.Employee;

import java.util.List;

public interface EmployeeService {

    EmployeeResponse saveEmployee(EmployeeRequest dto);

    List<EmployeeResponse> getAllEmployee();

    EmployeeResponse getEmployeeById(Long id);

    EmployeeResponse updateEmployee(EmployeeRequest employee, Long id);

    void deleteEmployeeById(Long id);

}
