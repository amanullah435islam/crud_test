package com.example.testRepo;

import com.example.entity.Patient;
import com.example.enums.Gender;
import com.example.repo.PatientRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import java.util.List;
import java.util.Optional;


//only repository test ar jonno but mail keno laglo jani na ata na dile bar bar error astecilo:
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PatientTestRepo {

    @Autowired
    private PatientRepo patientRepo;

    @MockitoBean
    private JavaMailSender javaMailSender;

    @Test
    void testSavePatient(){

        Patient patient = new Patient();

        patient.setName("Aman");
        patient.setGender(Gender.Male);
        patient.setAddress("Dhaka");
        patient.setAge(25L);
        patient.setDescription("Regular Patient");

        Patient savePatient = patientRepo.save(patient);

        Assertions.assertThat(savePatient).isNotNull();
        Assertions.assertThat(savePatient.getId()).isNotNull();
        Assertions.assertThat(savePatient.getName()).isEqualTo("Aman");



//       Optional code:
//        Assertions.assertThat(savePatient.getGender()).isEqualTo(Gender.Male);
//        Assertions.assertThat(savePatient.getAddress()).isEqualTo("Dhaka");
//        Assertions.assertThat(savePatient.getAge()).isEqualTo(25L);
//        Assertions.assertThat(savePatient.getDescription()).isEqualTo("Regular Patient");

    }



    @Test
    void testFindAllPatients(){

        Patient p1 = new Patient(null, "Anan", Gender.Male, "Dhaka", 25L, "Patient One");
        Patient p2 = new Patient(null, "Rahim", Gender.Male, "Thakurgaon", 30L, "Patient Two");

        patientRepo.save(p1);
        patientRepo.save(p2);

        List<Patient> patientList  = patientRepo.findAll();

        Assertions.assertThat(patientList).isNotEmpty();
        Assertions.assertThat(patientList.size()).isGreaterThanOrEqualTo(2);


//       Optional code:
//        Assertions.assertThat(patientList.get(0)).isEqualTo(p1);
//        Assertions.assertThat(patientList.get(1)).isEqualTo(p2);


    }





    @Test
    void testFindPatientById(){


        Patient patient = new Patient();

        patient.setName("Karim");
        patient.setGender(Gender.Male);
        patient.setAddress("Dhaka");
        patient.setAge(25L);
        patient.setDescription("new Patient");

        Patient savePatient = patientRepo.save(patient);

        Optional<Patient> result = patientRepo.findById(savePatient.getId());


        Assertions.assertThat(result).isPresent();
        Assertions.assertThat(result.get().getName()).isEqualTo("Karim");



//       Optional code:
//        Assertions.assertThat(result.get().getGender()).isEqualTo(Gender.Male);
//        Assertions.assertThat(result.get().getAddress()).isEqualTo("Dhaka");
//        Assertions.assertThat(result.get().getAge()).isEqualTo(25L);
//        Assertions.assertThat(result.get().getDescription()).isEqualTo("new Patient");


    }


    @Test
    void testExistsById(){


        Patient patient = new Patient();

        patient.setName("Karim");
        patient.setGender(Gender.Male);
        patient.setAddress("Rajshahi");
        patient.setAge(28L);
        patient.setDescription("New Patient");

        Patient savePatient = patientRepo.save(patient);

        Boolean exists = patientRepo.existsById(savePatient.getId());


        Assertions.assertThat(exists).isTrue();


//       Optional code:
//        Assertions.assertThat(savePatient.getId()).isNotNull();
//        Assertions.assertThat(savePatient.getName()).isEqualTo("Karim");
//        Assertions.assertThat(savePatient.getGender()).isEqualTo(Gender.Male);
//        Assertions.assertThat(savePatient.getAddress()).isEqualTo("Dhaka");
//        Assertions.assertThat(savePatient.getAge()).isEqualTo(28L);
//        Assertions.assertThat(savePatient.getDescription()).isEqualTo("New Patient");


    }





    @Test
    void testDeletePatient(){
        Patient patient = new Patient();
        patient.setName("Delete User");
        patient.setGender(Gender.Male);
        patient.setAddress("Sylhet");
        patient.setAge(35L);
        patient.setDescription("Delete Test");

        Patient saved = patientRepo.save(patient);

        patientRepo.deleteById(saved.getId());

        Optional<Patient> result = patientRepo.findById(saved.getId());

        Assertions.assertThat(result).isNotPresent();



//      Optional code:
//        Assertions.assertThat(saved.getId()).isNotNull();
//        Assertions.assertThat(saved.getName()).isEqualTo("test");
//        Assertions.assertThat(saved.getGender()).isEqualTo(Gender.Male);
//        Assertions.assertThat(saved.getAddress()).isEqualTo("Sylhet");
//        Assertions.assertThat(saved.getAge()).isEqualTo(35L);
//        Assertions.assertThat(saved.getDescription()).isEqualTo("Delete Test");

    }




    @Test
    void testCountPatients(){

        Long countBefore = patientRepo.count();

        Patient patient = new Patient();
        patient.setName("Count User");
        patient.setGender(Gender.Female);
        patient.setAddress("Dhaka");
        patient.setAge(20L);
        patient.setDescription("Count Test");

        patientRepo.save(patient);

        Long countAfter = patientRepo.count();

        Assertions.assertThat(countAfter).isEqualTo(countBefore + 1);

    }

}
