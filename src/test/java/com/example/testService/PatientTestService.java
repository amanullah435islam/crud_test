package com.example.testService;

import com.example.dto.request.PatientRequest;
import com.example.dto.response.PatientResponse;
import com.example.entity.Patient;
import com.example.enums.Gender;
import com.example.repo.PatientRepo;
import com.example.service.PatientService;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
// or:
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Assertions;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PatientTestService {

    @Mock
    private PatientRepo patientRepo;

    @InjectMocks
    private PatientService patientService;

    @Test
    public void testCreatePatient() {

        PatientRequest request = new PatientRequest();
        request.setName("Aman");
        request.setAge(25L);
        request.setGender(Gender.Male);
        request.setAddress("Dhaka");
        request.setDescription("Regular Patient");

        Patient patient = new Patient();
        patient.setId(1L);
        patient.setName("Aman");
        patient.setGender(Gender.Male);
        patient.setAddress("Dhaka");
        patient.setAge(25L);
        patient.setDescription("Regular Patient");


        when(patientRepo.save(any(Patient.class))).thenReturn(patient);

        PatientResponse response = patientService.create(request);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(patient.getId(), response.getId());
        Assertions.assertEquals(patient.getName(), response.getName());

//     or:

        assertThat(response).isNotNull();
        assertThat(response.getId()).isEqualTo(1L);
        assertThat(response.getName()).isEqualTo("Aman");


//        Optional code:
//        Assertions.assertEquals(patient.getAge(), response.getAge());
//        Assertions.assertEquals(patient.getGender(), response.getGender());
//        Assertions.assertEquals(patient.getAddress(), response.getAddress());
//        Assertions.assertEquals(patient.getAge(), response.getAge());
//        Assertions.assertEquals(patient.getGender(), response.getGender());
//        Assertions.assertEquals(patient.getAddress(), response.getAddress());

        verify(patientRepo, times(1)).save(any(Patient.class));
    }


    @Test
    void testGetPatientById() {

        Patient patient = new Patient();
        patient.setId(1L);
        patient.setName("Aman");
        patient.setGender(Gender.Male);
        patient.setAddress("Dhaka");
        patient.setAge(25L);
        patient.setDescription("Regular Patient");

        when(patientRepo.findById(1L)).thenReturn(Optional.of(patient));

        PatientResponse response = patientService.getById(1L);

        assertThat(response).isNotNull();
        assertThat(response.getName()).isEqualTo("Aman");

        verify(patientRepo, times(1)).findById(1L);
    }

    @Test
    void testUpdatePatient() {

        PatientRequest request = new PatientRequest();
        request.setName("Updated Aman");
        request.setAge(30L);

        Patient patient = new Patient();
        patient.setId(1L);
        patient.setName("Aman");
        patient.setAge(25L);

        when(patientRepo.findById(1L)).thenReturn(Optional.of(patient));
        when(patientRepo.save(any(Patient.class))).thenAnswer(i -> i.getArgument(0));

        PatientResponse response = patientService.update(request, 1L);

        assertThat(response.getName()).isEqualTo("Updated Aman");
        assertThat(response.getAge()).isEqualTo(30L);

        verify(patientRepo).findById(1L);
        verify(patientRepo).save(any(Patient.class));
    }

    @Test
    void testDeletePatient() {

        Patient patient = new Patient();
        patient.setId(1L);
        patient.setName("Aman");

        when(patientRepo.findById(1L)).thenReturn(Optional.of(patient));

        Patient deleted = patientService.Delete(1L);

        assertThat(deleted).isNotNull();
        assertThat(deleted.getName()).isEqualTo("Aman");

        verify(patientRepo).findById(1L);
        verify(patientRepo).delete(patient);
    }
}
