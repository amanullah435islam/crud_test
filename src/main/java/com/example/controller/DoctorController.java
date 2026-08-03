package com.example.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.dto.request.DoctorRegistrationDTO;
import com.example.dto.request.DoctorRequest;
import com.example.dto.response.DoctorResponse;
import com.example.service.DoctorService;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Doctor APIs", description = "Operations related to doctors")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@PostMapping("/doctor/save")
	@Operation(summary = "Create Doctor")
	public ResponseEntity<DoctorResponse> saveDoctor(@RequestBody DoctorRequest request) {
		
		DoctorResponse response = doctorService.create(request);	
		
		return ResponseEntity.ok(response);
	}
	
	
	
	
	
	@GetMapping("/doctor/get")
	@Operation(summary = "Get all doctors",
			description = "Returns a list of all doctors")
	public ResponseEntity<List<DoctorResponse>> getDoctor() {
		
		List<DoctorResponse> response = doctorService.get();
		
		return ResponseEntity.ok(response);
	}
	
	
	
	
	
	@GetMapping("/doctor/get/{id}")
	@Operation(summary = "Get doctor by ID")
	public ResponseEntity<?> getDoctorById(
			@Parameter(
					description = "Doctor ID",
					example = "10"
			)
			@PathVariable Long id
	) {
		
		try {	        
	        DoctorResponse response = doctorService.getById(id);
	        return ResponseEntity.ok(response);
	        
	    } catch (RuntimeException e) { 
	    	// return ResponseEntity.status(404).body(e.getMessage());
	        return ResponseEntity
	                .status(HttpStatus.NOT_FOUND)
	                .body("Error: " + e.getMessage());
	    }
	}
	
	
	
	
	
	@DeleteMapping("/doctor/delete/{id}")
	@Operation(summary = "Delete Doctor")
	public ResponseEntity<String> deleteDoctor(
			@Parameter(
					description = "Doctor ID",
					example = "5"
			)
			@PathVariable Long id
	) {
		
		 try {
			 doctorService.delete(id);
	            return ResponseEntity.ok("User deleted successfully with id: " + id);
	        } catch (RuntimeException e) {
	            return ResponseEntity.status(404).body(e.getMessage());
	        }
	}
	
	
	

	@PutMapping("/doctor/update/{id}")
	@Operation(summary = "Create Doctor")
	public ResponseEntity<?> updateDoctor(@PathVariable Long id, @RequestBody DoctorRequest request) {
		
		try {
			
			DoctorResponse response = doctorService.updateDoctor(id, request);
		    return ResponseEntity.ok(response);	
			
		} catch (RuntimeException e) {
			
			return ResponseEntity.status(404).body(e.getMessage());
			
		}
	    
	}

}
