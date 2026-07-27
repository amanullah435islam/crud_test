package com.example.sercice_implement;

import com.example.dto.request.EmployeeRequest;
import com.example.dto.response.EmployeeResponse;
import com.example.entity.Employee;
import com.example.repo.EmployeeRepo;
import com.example.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmpServiceImp implements EmployeeService {

    private final EmployeeRepo empRepo;


    @Override

    public EmployeeResponse saveEmployee(EmployeeRequest dto) {

            Employee employee = new Employee();

            employee.setName(dto.getName());
            employee.setAddress(dto.getAddress());
            employee.setCity(dto.getCity());
            employee.setState(dto.getState());
            employee.setZipCode(dto.getZipCode());
            employee.setCountry(dto.getCountry());

            Employee savedEmployee =
                    empRepo.save(employee);

            return new EmployeeResponse(
                    savedEmployee.getId(),
                    savedEmployee.getName(),
                    savedEmployee.getAddress(),
                    savedEmployee.getCity(),
                    savedEmployee.getState(),
                    savedEmployee.getZipCode(),
                    savedEmployee.getCountry()
            );
        }



    @Override
    public List<EmployeeResponse> getAllEmployee()
    {
        return empRepo.findAll().stream()
                .map(
                        (employees) ->
                                new EmployeeResponse(
                                        employees.getId(),
                                        employees.getName(),
                                        employees.getAddress(),
                                        employees.getCity(),
                                        employees.getState(),
                                        employees.getZipCode(),
                                        employees.getCountry()
                                )
                )
                .collect(Collectors.toList());



    }

    @Override
    public EmployeeResponse getEmployeeById(Long id) {



        try {
            Employee employees = empRepo.findById(id)
                    .orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
            return new EmployeeResponse(
                    employees.getId(),
                    employees.getName(),
                    employees.getAddress(),
                    employees.getCity(),
                    employees.getState(),
                    employees.getZipCode(),
                    employees.getCountry()
            );
        }catch (RuntimeException e){
            System.out.println("Exception logs tracking system event catch trigger message check: " + e.getMessage());
            throw e;
        }
    }



    @Override
    public EmployeeResponse updateEmployee(EmployeeRequest employee, Long id) {

        Employee existingEmployee = empRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id " + id));

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

        Employee savedEmployee = empRepo.save(existingEmployee );

        return new EmployeeResponse(
                savedEmployee.getId(),
                savedEmployee.getName(),
                savedEmployee.getAddress(),
                savedEmployee.getCity(),
                savedEmployee.getState(),
                savedEmployee.getZipCode(),
                savedEmployee.getCountry()
        );
    }





    @Override
    public void deleteEmployeeById(Long id) {
        if (!empRepo.existsById(id)) {
            throw new RuntimeException("Cannot delete. User not found with id: " + id);
        }

        empRepo.deleteById(id);
    }

}
