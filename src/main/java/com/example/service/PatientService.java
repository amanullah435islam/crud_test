package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.example.customException.ResourceNotFoundException;
import com.example.dto.request.PatientRequest;
import com.example.dto.response.PatientResponse;
import com.example.dto.response.UserResponse;
import com.example.entity.Patient;
import com.example.repo.PatientRepo;

@Service
public class PatientService {

	private final PatientRepo patientRepo;

	public PatientService(PatientRepo patientRepo) {
		
		this.patientRepo = patientRepo;
	}
	
	
	public PatientResponse create(PatientRequest patient) {
		
		Patient p = new Patient();
		
		p.setName(patient.getName());
		p.setAge(patient.getAge());
		p.setAddress(patient.getAddress());
		p.setGender(patient.getGender());
		p.setDescription(patient.getDescription());
		
		Patient savepatient = patientRepo.save(p);
		
		return new PatientResponse(
				
				savepatient.getId(),
				savepatient.getName(),
				savepatient.getAge(),
				savepatient.getGender(),
				savepatient.getAddress(),
				savepatient.getDescription()				
				);
	}
	
	
	public List<PatientResponse> getAll() {
		
		List<PatientResponse> p = patientRepo.findAll().stream()
				
									        .map(patient -> new PatientResponse(patient.getId(),patient.getName(),
									        		
									        		patient.getAge(),patient.getGender(),
									        		
									        		patient.getAddress(),patient.getDescription()
									        		
									        		))
									        
									        .collect(Collectors.toList());										
		
		return p;
	}
	
	

	
	public PatientResponse getById(Long id) {
		
		Patient patient = patientRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("patient not found with id : " + id));	
		
		return new PatientResponse( patient.getId(),patient.getName(),
        		
        		patient.getAge(),patient.getGender(),
        		
        		patient.getAddress(),patient.getDescription()
        		
				);
	}
	
	
	
	public PatientResponse update(PatientRequest patient, Long id) {
		
		Patient patientExisting = patientRepo.findById(id)
		.orElseThrow(() -> new RuntimeException("patient not found with id : " + id));		
		
		if (patient.getName() != null) {
			patientExisting.setName(patient.getName());
		}
		
		
		if (patient.getAge() != null) {
			patientExisting.setAge(patient.getAge());
		}
		
		
		if (patient.getGender() != null) {
			patientExisting.setGender(patient.getGender());
		}
		
		
		if (patient.getAddress() != null) {
			patientExisting.setAddress(patient.getAddress());
		}
		
		
		if (patient.getDescription() != null) {
			patientExisting.setDescription(patient.getDescription());	
		}
		
		
		Patient p = patientRepo.save(patientExisting);
		
		return new PatientResponse( p.getId(),p.getName(),
        		
        		p.getAge(),p.getGender(),
        		
        		p.getAddress(),p.getDescription()
        		
				);
		
	}
	
	
	public Patient Delete(Long id) {

	    Patient patient = patientRepo.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));

	    patientRepo.delete(patient);

	    return patient;
	}
	
	
	
}




