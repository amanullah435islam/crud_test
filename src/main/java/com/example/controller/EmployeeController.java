package com.example.controller;

import com.example.dto.request.EmployeeRequest;
import com.example.dto.response.EmployeeResponse;
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
    public ResponseEntity<EmployeeResponse> save(@RequestBody EmployeeRequest employee) {

        EmployeeResponse savedEmployee =
                employeeService.saveEmployee(employee);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedEmployee);
    }


    @GetMapping("/get")
    public ResponseEntity<List<EmployeeResponse>> getAll()
    {
            return ResponseEntity.ok(employeeService.getAllEmployee());
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id)
    {
        try {
            return ResponseEntity.ok(employeeService.getEmployeeById(id));
        }catch (RuntimeException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Error : " + e.getMessage());
        }

    }




    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody EmployeeRequest employee, @PathVariable Long id) {
        try {
            return ResponseEntity.ok(employeeService.updateEmployee(employee, id));
        } catch (RuntimeException ex) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ex.getMessage());
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {

        try {
            employeeService.deleteEmployeeById(id);
            return ResponseEntity.ok("Deleted Employee with id: " + id);
        }catch (RuntimeException ex) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Error : " + ex.getMessage());
        }


    }


}
