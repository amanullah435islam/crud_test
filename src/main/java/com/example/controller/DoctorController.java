package com.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Doctor;
import com.example.response.DoctorRequest;
import com.example.response.DoctorResponse;
import com.example.response.UserResponse;
import com.example.service.DoctorService;

@RestController
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/doctor/save")
	public ResponseEntity<DoctorResponse> saveDoctor(@RequestBody DoctorRequest request) {
		
		DoctorResponse response = doctorService.create(request);	
		
		return ResponseEntity.ok(response);
	}
	
	
	
	@GetMapping("/doctor/get")
	public ResponseEntity<List<DoctorResponse>> getDoctor() {
		
		List<DoctorResponse> response = doctorService.get();
		
		return ResponseEntity.ok(response);
	}
	
	
	@GetMapping("/doctor/get/{id}")
	public ResponseEntity<?> getDoctorById(@PathVariable Long id) {

		 try {
			 DoctorResponse response = doctorService.getById(id);
	            return ResponseEntity.ok(response);
	        } catch (RuntimeException e) {
	            return ResponseEntity.status(404).body(e.getMessage());
	        }
	}
	
	@DeleteMapping("/doctor/delete/{id}")
	public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {
		
		 try {
			 doctorService.delete(id);
	            return ResponseEntity.ok("User deleted successfully with id: " + id);
	        } catch (RuntimeException e) {
	            return ResponseEntity.status(404).body(e.getMessage());
	        }
	}
	
	
	
	 // PUT method to update an existing Doctor by their ID
    @PutMapping("/doctor/update/{id}")
    public ResponseEntity<DoctorResponse> updateDoctor(@PathVariable Long id, @RequestBody DoctorRequest DoctorDetails) {
        DoctorResponse updatedDoctor = doctorService.update(id, DoctorDetails);
        return ResponseEntity.ok(updatedDoctor);
    }
    
    
    
}
