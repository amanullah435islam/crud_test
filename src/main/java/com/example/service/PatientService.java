package com.example.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.customException.ResourceNotFoundException;
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
				.orElseThrow(() -> new ResourceNotFoundException("patient not found with id : " + id));			
	}
	
	
	
	public Patient update(Patient patient, Long id) {
		
		Patient existingPatient = patientRepo.findById(id)
		.orElseThrow(() -> new RuntimeException("patient not found with id : " + id));		
		
		if (patient.getName() != null) {
		    existingPatient.setName(patient.getName());
		}

		if (patient.getGender() != null) {
		    existingPatient.setGender(patient.getGender());
		}

		if (patient.getAddress() != null) {
		    existingPatient.setAddress(patient.getAddress());
		}

		if (patient.getAge() != null) {
		    existingPatient.setAge(patient.getAge());
		}

		if (patient.getDescription() != null) {
		    existingPatient.setDescription(patient.getDescription());
		}	
		
		Patient p = patientRepo.save(existingPatient);
		
		return p;
		
	}
	
	
	public Patient Delete(Long id) {

	    Patient patient = patientRepo.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));

	    patientRepo.delete(patient);

	    return patient;
	}
	
	
	
}




