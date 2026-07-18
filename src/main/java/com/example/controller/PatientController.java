package com.example.controller;

import java.util.List;

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
	public Patient createPatient(@RequestBody Patient patient) {
		
		return patientService.create(patient);
	}
	
	@GetMapping("/getAll")
	public List<Patient> getAllPatient() {
		
		List<Patient> patient = patientService.getAll();
		
		return patient;
		
	}
	
	
	@GetMapping("/get/{id}")
	public Patient getByPatientId(@PathVariable Long id) {
		
		return patientService.getById(id);
		
	}
	
	
	@PutMapping("/update/{id}")
	public Patient updatePatient(@RequestBody Patient patient, @PathVariable Long id) {
		
		return patientService.update(patient, id);
		
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void deletePatient(@PathVariable Long id) {
		
		patientService.delete(id);
	}
	
	
}



//	//MORE PROFESSIONAL:
				//
				//@PostMapping
				//public ResponseEntity<Patient> create(@RequestBody Patient patient)
				//
				//@GetMapping
				//public ResponseEntity<List<Patient>> getAll()
				//
				//@GetMapping("/{id}")
				//public ResponseEntity<Patient> getById(@PathVariable Long id)
				//
				//@PutMapping("/{id}")
				//public ResponseEntity<Patient> update(@PathVariable Long id,
				//                                      @RequestBody Patient patient)
				//
				//@DeleteMapping("/{id}")
				//public ResponseEntity<Void> delete(@PathVariable Long id)
				//

