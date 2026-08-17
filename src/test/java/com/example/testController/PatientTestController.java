package com.example.testController;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import com.example.dto.request.PatientRequest;
import com.example.dto.response.PatientResponse;
import com.example.enums.Gender;
import com.example.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;  //POST, GET, PUT, DELETE
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;   //status, jsonPath, content

//      // full project ar jonno ai duita annotation use kora hoi.......

//@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc

//or:

@SpringBootTest
@AutoConfigureMockMvc
public class PatientTestController {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private PatientService patientService;


    @Test
    void testCreatePatient() throws Exception {

        // Arrange
        PatientRequest request = new PatientRequest();

        request.setName("Aman");
        request.setAge(25L);
        request.setGender(Gender.Male);
        request.setAddress("Dhaka");
        request.setDescription("Regular Patient");


        PatientResponse response = new PatientResponse(
                1L,
                "Aman",
                25L,
                Gender.Male,
                "Dhaka",
                "Regular Patient"
        );


        when(patientService.create(any(PatientRequest.class)))
                .thenReturn(response);


        // Act + Assert
        mockMvc.perform(
                        post("/api/auth/patient/save")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(
                                        objectMapper.writeValueAsString(request)
                                )
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Aman"));
    }
}