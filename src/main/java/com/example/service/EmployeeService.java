package com.example.service;

import com.example.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployee();

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Employee employee, Long id);

    void deleteEmployeeById(Long id);

}
