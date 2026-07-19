package com.example.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.customException.ResourceNotFoundException;
import com.example.dto.request.PatientRequest;
import com.example.entity.Patient;
import com.example.repo.PatientRepo;

@Service
public class PatientService {

	private final PatientRepo patientRepo;

	public PatientService(PatientRepo patientRepo) {
		
		this.patientRepo = patientRepo;
	}
	
	
	public Patient create(PatientRequest patient) {
		
		Patient p = new Patient();
		
		p.setName(patient.getName());
		p.setAge(patient.getAge());
		p.setAddress(patient.getAddress());
		p.setGender(patient.getGender());
		p.setDescription(patient.getDescription());
		
		return patientRepo.save(p);
	}
	
	
	
	public List<Patient> getAll() {
		
		List<Patient> p = patientRepo.findAll();
		
		return p;
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




