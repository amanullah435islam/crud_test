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
	
	
	public DoctorResponse update(Long id, DoctorRequest doctorDetails) {
        
		Doctor existingDoctor = doctorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));

        
        existingDoctor.setName(doctorDetails.getName());
        existingDoctor.setAge(doctorDetails.getAge());
        existingDoctor.setDesignation(doctorDetails.getDesignation());
        existingDoctor.setSalary(doctorDetails.getSalary());

        
        Doctor response = doctorRepo.save(existingDoctor);
         
         return new DoctorResponse(
				        		 response.getId(),
				        		 response.getName(),
				        		 response.getAge(),
				        		 response.getDesignation(),
				        		 response.getSalary()
				        		 );
    }
}
