package com.example.sercice_implement;

import com.example.entity.Employee;
import com.example.repo.EmployeeRepo;
import com.example.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpServiceImp implements EmployeeService {

    private final EmployeeRepo empRepo;

    @Override
    public Employee saveEmployee(Employee employee) {

        return empRepo.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee()
    {

        return empRepo.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return empRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {

        Employee existingEmployee  = getEmployeeById(id);

        if (employee.getName() != null) {
            existingEmployee .setName(employee.getName());
        }

        if (employee.getAddress() != null) {
            existingEmployee .setAddress(employee.getAddress());
        }
        if (employee.getCity() != null) {
            existingEmployee .setCity(employee.getCity());
        }
        if (employee.getState() != null) {
            existingEmployee .setState(employee.getState());
        }
        if (employee.getZipCode() != null) {
            existingEmployee .setZipCode(employee.getZipCode());
        }
        if (employee.getCountry() != null) {
            existingEmployee .setCountry(employee.getCountry());
        }

        return empRepo.save(existingEmployee );
    }





    @Override
    public void deleteEmployeeById(Long id) {
        Employee employee = empRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id " + id));

        empRepo.delete(employee);
    }

}
