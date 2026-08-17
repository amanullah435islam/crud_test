package com.example.testController;

import com.example.controller.AppointmentController;
import com.example.entity.Appointment;
import com.example.service.AppointmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.time.LocalDateTime;


@ExtendWith(MockitoExtension.class)
public class TestAppointmentController {

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @Mock
    private AppointmentService appointmentService;


    @BeforeEach
    void setUp() {

        AppointmentController appointmentController =
                new AppointmentController(appointmentService);

        mockMvc = MockMvcBuilders
                .standaloneSetup(appointmentController)
                .build();

        objectMapper = new ObjectMapper();
    }


    // =========================
    // CREATE / POST
    // =========================

    @Test
    void testSaveAppointment() throws Exception {

        Appointment appointment = new Appointment();

        appointment.setId(1L);
        appointment.setDescription("Test appointment");
        appointment.setDepartment("Cardiology");
        appointment.setRoom("Room 101");
        appointment.setRoomNumber("B-201");
        appointment.setRoomType("Cabin");
        appointment.setRoomStatus("Available");

        when(appointmentService.save(any(Appointment.class)))
                .thenReturn(appointment);


        mockMvc.perform(
                        post("/api/auth/appointment/save")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(appointment))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.description")
                        .value("Test appointment"))
                .andExpect(jsonPath("$.department")
                        .value("Cardiology"));
    }


    // =========================
    // GET ALL
    // =========================

    @Test
    void testGetAllAppointment() throws Exception {

        Appointment appointment = new Appointment();

        appointment.setId(1L);
        appointment.setDescription("Test appointment");
        appointment.setDepartment("Cardiology");

        when(appointmentService.getAll())
                .thenReturn(java.util.List.of(appointment));


        mockMvc.perform(
                        get("/api/auth/appointment/get")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].description")
                        .value("Test appointment"))
                .andExpect(jsonPath("$[0].department")
                        .value("Cardiology"));
    }


    // =========================
    // GET BY ID
    // =========================

    @Test
    void testGetAppointmentById() throws Exception {

        Appointment appointment = new Appointment();

        appointment.setId(1L);
        appointment.setDescription("Test appointment");
        appointment.setDepartment("Cardiology");


        when(appointmentService.findById(1L))
                .thenReturn(appointment);


        mockMvc.perform(
                        get("/api/auth/appointment/1")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.description")
                        .value("Test appointment"))
                .andExpect(jsonPath("$.department")
                        .value("Cardiology"));
    }


    // =========================
    // UPDATE
    // =========================

    @Test
    void testUpdateAppointment() throws Exception {

        Appointment appointment = new Appointment();

        appointment.setId(1L);
        appointment.setDescription("Updated appointment");
        appointment.setDepartment("Neurology");
        appointment.setRoom("Room 202");
        appointment.setRoomNumber("B-202");
        appointment.setRoomType("Cabin");
        appointment.setRoomStatus("Available");


        when(appointmentService.update(
                any(Appointment.class),
                eq(1L)
        )).thenReturn(appointment);


        mockMvc.perform(
                        put("/api/auth/appointment/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(appointment))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.description")
                        .value("Updated appointment"))
                .andExpect(jsonPath("$.department")
                        .value("Neurology"));
    }


    // =========================
    // DELETE
    // =========================

    @Test
    void testDeleteAppointment() throws Exception {

        doNothing()
                .when(appointmentService)
                .delete(1L);


        mockMvc.perform(
                        delete("/api/auth/appointment/1")
                )
                .andExpect(status().isOk());


        verify(appointmentService, times(1))
                .delete(1L);
    }
}