package com.example.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Doctor;
import com.example.repo.DoctorRepo;
import com.example.response.DoctorRequest;
import com.example.response.DoctorResponse;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepo doctorRepo;
	
	
	public DoctorResponse create(DoctorRequest request) {
		
		Doctor doctor = new Doctor();
		
		doctor.setName(request.getName());
		doctor.setAge(request.getAge());
		doctor.setDesignation(request.getDesignation());
		doctor.setSalary(request.getSalary());
		
		Doctor saveDoctor = doctorRepo.save(doctor);
		
		return new DoctorResponse(
				saveDoctor.getId(),
				saveDoctor.getName(),
				saveDoctor.getAge(),
				saveDoctor.getDesignation(),
				saveDoctor.getSalary()
				);	
	}
	
	
	public List<DoctorResponse> get(){
		
		return  doctorRepo.findAll().stream()
							 .map(doctor -> new DoctorResponse(
															 doctor.getId(),
															 doctor.getName(),
															 doctor.getAge(),
															 doctor.getDesignation(),
															 doctor.getSalary())
							   )
							 .collect(Collectors.toList());
	}
	
	
	public DoctorResponse getById(Long id) {
		
		Doctor d = doctorRepo.findById(id)
					.orElseThrow(() -> new RuntimeException("user not found with id: " + id));
		
		return new DoctorResponse(
								d.getId(),
								d.getName(),
								d.getAge(),
								d.getDesignation(),
								d.getSalary()
								);
		
	}
	
	
	
	public void delete(Long id) {
		
		  if (!doctorRepo.existsById(id)) {
	            throw new RuntimeException("Cannot delete. User not found with id: " + id);
	        }
		  
		  doctorRepo.deleteById(id);
		  
	}
	

	
	
	
	public DoctorResponse updateDoctor(Long id, DoctorRequest request) {
	    // 1. Find the existing doctor from DB
	    Doctor existingDoctor = doctorRepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));

	    // 2. Only update fields if they are provided in the request body
	    if (request.getName() != null) {
	        existingDoctor.setName(request.getName());
	    }
	    
	    if (request.getAge() != null) {
	        existingDoctor.setAge(request.getAge());
	    }
	    
	    if (request.getDesignation() != null) {
	        existingDoctor.setDesignation(request.getDesignation());
	    }
	    
	    // For primitive double, we check if it's greater than 0 before updating
	    if (request.getSalary() > 0) {
	        existingDoctor.setSalary(request.getSalary());
	    }

	    // 3. Save the modified doctor object back to DB
	    Doctor updatedDoctor = doctorRepo.save(existingDoctor);

	    // 4. Return converted DoctorResponse DTO
	    return new DoctorResponse(
	            updatedDoctor.getId(),
	            updatedDoctor.getName(),
	            updatedDoctor.getAge(),
	            updatedDoctor.getDesignation(),
	            updatedDoctor.getSalary()
	    );
	}
	
	

}
