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
    public ResponseEntity<EmployeeResponse> save(@RequestBody EmployeeRequest employee)
    {
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
    public ResponseEntity<EmployeeResponse> getById(
            @PathVariable Long id)
    {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }



    //@PutMapping("/update/{id}")             // use for full update code
    @PatchMapping("/update/{id}")           //use for Partial Update
    public ResponseEntity<EmployeeResponse> update(@RequestBody EmployeeRequest employee, @PathVariable Long id)
    {
            return ResponseEntity.ok(employeeService.updateEmployee(employee, id));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id)
    {
            employeeService.deleteEmployeeById(id);
            return ResponseEntity.ok("Deleted Employee with id: " + id);
    }


}
