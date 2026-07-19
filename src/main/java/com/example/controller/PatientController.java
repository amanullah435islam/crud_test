package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
		
		return ResponseEntity.ok(patientService.create(patient));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Patient>> getAllPatient() {
		
		List<Patient> patient = patientService.getAll();
		
		return ResponseEntity.ok(patient); 
		
	}
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getByPatientId(@PathVariable Long id) {
		
		
		
		try {
			Patient patient = patientService.getById(id);
			return ResponseEntity.ok(patient);
		} catch (Exception e) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(e.getMessage());
					
		}
		
	}
	
	@GetMapping("/Get2/{id}")
	public ResponseEntity<Patient> getByPatientID2(@PathVariable Long id) {
		
	    return patientService.getByID(id)
	    		
	            .map(ResponseEntity::ok)
	            
	            .orElseGet(() -> ResponseEntity.notFound().build());
	}



	@GetMapping("/Get/{id}")
	    public ResponseEntity<?>  getByPatientID(@PathVariable Long id) {
		
	        return patientService.getByID(id)
	        		
	        					 .map(ResponseEntity::ok)
	        					 
	        					 .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
	        
	    }

	
	@PutMapping("/update/{id}")
	public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient, @PathVariable Long id) {
		
		return ResponseEntity.ok(patientService.update(patient, id));
		
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePatient(@PathVariable Long id) {
		
		patientService.delete(id);
		
		return ResponseEntity.ok("Delete Successfully.");
	}
	
	
}


