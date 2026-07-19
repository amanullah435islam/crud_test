package com.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.request.PatientRequest;
import com.example.dto.response.PatientResponse;
import com.example.entity.Patient;
import com.example.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {

	private final PatientService patientService;

	public PatientController(PatientService patientService) {
	
		this.patientService = patientService;
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<PatientResponse> createPatient(@RequestBody PatientRequest patient) {
		
		return ResponseEntity.ok(patientService.create(patient));
	}
	
	
	
	@GetMapping("/getAll")
	public ResponseEntity<List<PatientResponse>> getAllPatient() {
		
		List<PatientResponse> patient = patientService.getAll2();
		
		return ResponseEntity.ok(patient); 
		
	}
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Patient> getById(@PathVariable Long id) {
		Patient patient = patientService.getById(id);
		return ResponseEntity.ok(patient);
	}
		
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updatePatient(@RequestBody PatientRequest patient, @PathVariable Long id) {
		
		
		try {
			return ResponseEntity.ok(patientService.update(patient, id));
			
		} catch (RuntimeException e) {
			
			return ResponseEntity
					
					.status(HttpStatus.NOT_FOUND)
					
					.body(e.getMessage());
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePatient(@PathVariable Long id) {
		
	
			patientService.Delete(id);
			
			return ResponseEntity.ok("Delete Successfully.");
			
		
		
	}
	
	
}


