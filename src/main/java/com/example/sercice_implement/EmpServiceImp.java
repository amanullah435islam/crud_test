package com.example.sercice_implement;

import com.example.customException.EmployeeNotFoundException;
import com.example.customException.ResourceNotFoundException;
import com.example.dto.request.EmployeeRequest;
import com.example.dto.response.EmployeeResponse;
import com.example.entity.Employee;
import com.example.mapper.EmployeeMapper;
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
private final EmployeeMapper empMapper;

    @Override

    public EmployeeResponse saveEmployee(EmployeeRequest dto) {

            Employee employee = empMapper.toEntity(dto);

            Employee savedEmployee =
                    empRepo.save(employee);

            return empMapper.toResponse(savedEmployee);
        }



    @Override
    public List<EmployeeResponse> getAllEmployee()
    {
        return empRepo.findAll()
                .stream()
                .map(empMapper::toResponse)
                .collect(Collectors.toList());
    }



    @Override
    public EmployeeResponse getEmployeeById(Long id) {

            Employee employees = empRepo.findById(id)
                    .orElseThrow(() -> new EmployeeNotFoundException(id));

            return empMapper.toResponse(employees);

    }



    @Override
    public EmployeeResponse updateEmployee(EmployeeRequest request, Long id) {

        Employee employee = empRepo.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(id)
                );

        empMapper.updateEntity(request,employee);

        Employee updatedEmployee  = empRepo.save(employee);

        return empMapper.toResponse(updatedEmployee );
    }





    @Override
    public void deleteEmployeeById(Long id) {
        
        if (!empRepo.existsById(id)) {
            throw new EmployeeNotFoundException(id);
        }

        empRepo.deleteById(id);
    }

}
