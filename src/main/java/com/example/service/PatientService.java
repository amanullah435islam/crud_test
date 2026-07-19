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
	
	
	
//	get all alternative / or :
	
	
	private PatientResponse mapToResponse(Patient patient) {

	    PatientResponse response = new PatientResponse();

	    response.setId(patient.getId());
	    response.setName(patient.getName());
	    response.setAge(patient.getAge());
	    response.setGender(patient.getGender());
	    response.setAddress(patient.getAddress());
	    response.setDescription(patient.getDescription());

	    return response;
	}
	
	
	
	public List<PatientResponse> getAll2() {

	    List<Patient> patients = patientRepo.findAll();

	    List<PatientResponse> responses = new ArrayList<>();

	    for (Patient patient : patients) {

	        PatientResponse response = mapToResponse(patient);

	        responses.add(response);
	    }

	    return responses;
	}
	
	
	
	
	
	
	
	
	public Patient getById(Long id) {
		
		return patientRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("patient not found with id : " + id));			
	}
	
	
	
	public Patient update(PatientRequest patient, Long id) {
		
		Patient patientExisting = patientRepo.findById(id)
		.orElseThrow(() -> new RuntimeException("patient not found with id : " + id));		
		
		patientExisting.setName(patient.getName());
		patientExisting.setAge(patient.getAge());
		patientExisting.setGender(patient.getGender());
		patientExisting.setAddress(patient.getAddress());
		patientExisting.setDescription(patient.getDescription());	
		
		Patient p = patientRepo.save(patientExisting);
		
		return p;
		
	}
	
	
	public Patient Delete(Long id) {

	    Patient patient = patientRepo.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));

	    patientRepo.delete(patient);

	    return patient;
	}
	
	
	
}




