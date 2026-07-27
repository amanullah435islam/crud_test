package com.example.controller;

import com.example.entity.Employee;
import com.example.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<Employee> save(@RequestBody Employee employee) {

        Employee savedEmployee =
                employeeService.saveEmployee(employee);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedEmployee);
    }


    @GetMapping("/get")
    public ResponseEntity<List<Employee>> getAll()
    {

        return ResponseEntity.ok(employeeService.getAllEmployee());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id)
    {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }




    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody Employee employee, @PathVariable Long id) {
        try {
            return ResponseEntity.ok(employeeService.updateEmployee(employee, id));
        } catch (RuntimeException ex) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ex.getMessage());
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {

        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok("Employee has been deleted");
    }


}
