package com.example.testService;

import com.example.entity.Appointment;
import com.example.repo.AppointmentRepo;
import com.example.sercice_implement.AppointmentServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;



@ExtendWith(MockitoExtension.class)
public class TestAppointmentService {

    @Mock
    private AppointmentRepo appointmentRepo;

    @InjectMocks
    private AppointmentServiceImp appointmentService;


    // =========================
    // SAVE
    // =========================
    @Test
    void testSaveAppointment() {

        Appointment appointment = new Appointment();

        appointment.setId(1L);
        appointment.setDescription("Test Appointment");
        appointment.setStartTime(
                LocalDateTime.of(2026, 8, 15, 9, 0)
        );
        appointment.setEndTime(
                LocalDateTime.of(2026, 8, 15, 10, 0)
        );
        appointment.setDepartment("Cardiology");
        appointment.setRoom("Room A");
        appointment.setRoomNumber("A-101");
        appointment.setRoomType("Cabin");
        appointment.setRoomStatus("Available");


        when(appointmentRepo.save(any(Appointment.class)))
                .thenReturn(appointment);


        Appointment savedAppointment =
                appointmentService.save(appointment);


        assertThat(savedAppointment).isNotNull();
        assertThat(savedAppointment.getId()).isEqualTo(1L);
        assertThat(savedAppointment.getDepartment())
                .isEqualTo("Cardiology");


        verify(appointmentRepo, times(1))
                .save(appointment);
    }


    // =========================
    // GET ALL
    // =========================
    @Test
    void testGetAllAppointment() {

        Appointment appointment1 = new Appointment();
        appointment1.setId(1L);
        appointment1.setDescription("Appointment 1");
        appointment1.setDepartment("Cardiology");


        Appointment appointment2 = new Appointment();
        appointment2.setId(2L);
        appointment2.setDescription("Appointment 2");
        appointment2.setDepartment("Neurology");


        List<Appointment> appointments =
                Arrays.asList(appointment1, appointment2);


        when(appointmentRepo.findAll())
                .thenReturn(appointments);


        List<Appointment> result =
                appointmentService.getAll();


        assertThat(result).isNotNull();
        assertThat(result).hasSize(2);
        assertThat(result.get(0).getDepartment())
                .isEqualTo("Cardiology");
        assertThat(result.get(1).getDepartment())
                .isEqualTo("Neurology");


        verify(appointmentRepo, times(1))
                .findAll();
    }


    // =========================
    // GET BY ID
    // =========================
    @Test
    void testGetAppointmentById() {

        Appointment appointment = new Appointment();

        appointment.setId(1L);
        appointment.setDescription("Get By ID Test");
        appointment.setDepartment("Cardiology");


        when(appointmentRepo.findById(1L))
                .thenReturn(Optional.of(appointment));


        Appointment result =
                appointmentService.findById(1L);


        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getDepartment())
                .isEqualTo("Cardiology");


        verify(appointmentRepo, times(1))
                .findById(1L);
    }


    // =========================
    // UPDATE
    // =========================
    @Test
    void testUpdateAppointment() {

        Appointment existingAppointment =
                new Appointment();

        existingAppointment.setId(1L);
        existingAppointment.setDescription("Old Description");
        existingAppointment.setDepartment("Cardiology");
        existingAppointment.setRoom("Room A");
        existingAppointment.setRoomNumber("A-101");
        existingAppointment.setRoomType("Cabin");
        existingAppointment.setRoomStatus("Available");


        Appointment updateAppointment =
                new Appointment();

        updateAppointment.setDescription("Updated Description");
        updateAppointment.setStartTime(
                LocalDateTime.of(2026, 8, 15, 11, 0)
        );
        updateAppointment.setEndTime(
                LocalDateTime.of(2026, 8, 15, 12, 0)
        );
        updateAppointment.setDepartment("Neurology");
        updateAppointment.setRoom("Room B");
        updateAppointment.setRoomNumber("B-202");
        updateAppointment.setRoomType("General");
        updateAppointment.setRoomStatus("Booked");


        when(appointmentRepo.findById(1L))
                .thenReturn(Optional.of(existingAppointment));

        when(appointmentRepo.save(any(Appointment.class)))
                .thenReturn(existingAppointment);


        Appointment result =
                appointmentService.update(updateAppointment, 1L);


        assertThat(result).isNotNull();

        assertThat(result.getDescription())
                .isEqualTo("Updated Description");

        assertThat(result.getDepartment())
                .isEqualTo("Neurology");

        assertThat(result.getRoomNumber())
                .isEqualTo("B-202");

        assertThat(result.getRoomStatus())
                .isEqualTo("Booked");


        verify(appointmentRepo, times(1))
                .findById(1L);

        verify(appointmentRepo, times(1))
                .save(existingAppointment);
    }


    // =========================
    // DELETE
    // =========================
    @Test
    void testDeleteAppointment() {

        Long id = 1L;

        Appointment appointment = new Appointment();
        appointment.setId(id);
        appointment.setDescription("Delete Test");
        appointment.setDepartment("Cardiology");


        // Service প্রথমে ID দিয়ে appointment খুঁজবে
        when(appointmentRepo.findById(id))
                .thenReturn(Optional.of(appointment));


        // Service-এর delete call-এর জন্য
        doNothing()
                .when(appointmentRepo)
                .delete(appointment);


        // Service call
        appointmentService.delete(id);


        // Verify
        verify(appointmentRepo, times(1))
                .findById(id);

        verify(appointmentRepo, times(1))
                .delete(appointment);
    }
}