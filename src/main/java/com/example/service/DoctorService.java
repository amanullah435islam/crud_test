package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Doctor;
import com.example.entity.User;
import com.example.repo.DoctorRepo;
import com.example.response.UserResponse;


@Service
public class DoctorService {

	@Autowired
	private DoctorRepo doctorRepo;
	
	
	public Doctor create(Doctor doctor) {
		
		return doctorRepo.save(doctor);	
		
		
//		Doctor d = doctorRepo.save(doctor);	
//		System.out.println(d);
//		return d;
	}
	
	
	public List<Doctor> get(){
		
		return  doctorRepo.findAll();
	}
	
	
	public Doctor getById(Long id) {
		
		Doctor d = doctorRepo.findById(id)
					.orElseThrow(() -> new RuntimeException("user not found with id: " + id));
		return d;
		
	}
	
	
	
	public void delete(Long id) {
		
		  if (!doctorRepo.existsById(id)) {
	            throw new RuntimeException("Cannot delete. User not found with id: " + id);
	        }
		  
		  doctorRepo.deleteById(id);
		  
	}
	
	
	public Doctor update(Long id, Doctor doctorDetails) {
        // Find the existing Doctor or throw an error if they don't exist
		Doctor existingDoctor = doctorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));

        // Map the incoming update data to the existing database record
        existingDoctor.setName(doctorDetails.getName());
        existingDoctor.setAge(doctorDetails.getAge());
        existingDoctor.setDesignation(doctorDetails.getDesignation());
        existingDoctor.setSalary(doctorDetails.getSalary());

        // Save the updated Doctor record back to the database
        return doctorRepo.save(existingDoctor);
    }
}
