package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.entity.Patient;
import com.example.repo.PatientRepo;

@Service
public class PatientService {

	private final PatientRepo patientRepo;

	public PatientService(PatientRepo patientRepo) {
		
		this.patientRepo = patientRepo;
	}
	
	
	public Patient create(Patient patient) {
		
		Patient p = patientRepo.save(patient);
		
		return p;
	}
	
	
	
	public List<Patient> getAll() {
		
		List<Patient> p = patientRepo.findAll();
		
		return p;
	}
	
	
	public Patient getById(Long id) {
		
		return patientRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("patient not found with id : " + id));			
	}
	
	public Optional<Patient> getByID(Long id) {
		
		return patientRepo.findById(id);
						
	}
	
	
	public Patient update(Patient patient, Long id) {
		
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
	
	
	public void delete(Long id) {
		
		Patient patient = patientRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("patient not found with id : " + id));	

		 patientRepo.delete(patient);
		
	}	
	
	public Patient Delete(Long id) {

	    Patient patient = patientRepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));

	    patientRepo.delete(patient);

	    return patient;
	}
	
	
	
}




