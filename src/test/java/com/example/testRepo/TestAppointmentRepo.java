package com.example.testRepo;

import com.example.entity.Appointment;
import com.example.repo.AppointmentRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestAppointmentRepo {

    @Autowired
    private AppointmentRepo appointmentRepo;


    @MockitoBean
    private JavaMailSender javaMailSender;
    // =========================
    // SAVE
    // =========================
    @Test
    void testSaveAppointment() {

        Appointment appointment = new Appointment();

        appointment.setDescription("test appointment");
        appointment.setStartTime(
                LocalDateTime.of(2026, 8, 15, 9, 0)
        );
        appointment.setEndTime(
                LocalDateTime.of(2026, 8, 15, 10, 0)
        );
        appointment.setDepartment("test department");
        appointment.setRoom("test room");
        appointment.setRoomNumber("B-201");
        appointment.setRoomType("Cabin");
        appointment.setRoomStatus("Available");

        Appointment savedAppointment =
                appointmentRepo.save(appointment);

        assertThat(savedAppointment).isNotNull();
        assertThat(savedAppointment.getId()).isNotNull();
        assertThat(savedAppointment.getDepartment())
                .isEqualTo("test department");
    }


    // =========================
    // GET ALL
    // =========================
    @Test
    void testGetAllAppointment() {

        Appointment appointment1 = new Appointment();

        appointment1.setDescription("Appointment 1");
        appointment1.setStartTime(
                LocalDateTime.of(2026, 8, 15, 9, 0)
        );
        appointment1.setEndTime(
                LocalDateTime.of(2026, 8, 15, 10, 0)
        );
        appointment1.setDepartment("Cardiology");
        appointment1.setRoom("Room A");
        appointment1.setRoomNumber("A-101");
        appointment1.setRoomType("Cabin");
        appointment1.setRoomStatus("Available");


        Appointment appointment2 = new Appointment();

        appointment2.setDescription("Appointment 2");
        appointment2.setStartTime(
                LocalDateTime.of(2026, 8, 15, 11, 0)
        );
        appointment2.setEndTime(
                LocalDateTime.of(2026, 8, 15, 12, 0)
        );
        appointment2.setDepartment("Neurology");
        appointment2.setRoom("Room B");
        appointment2.setRoomNumber("B-201");
        appointment2.setRoomType("General");
        appointment2.setRoomStatus("Available");


        appointmentRepo.save(appointment1);
        appointmentRepo.save(appointment2);


        List<Appointment> appointments =
                appointmentRepo.findAll();

        assertThat(appointments).isNotEmpty();
        assertThat(appointments.size()).isGreaterThanOrEqualTo(2);
    }


    // =========================
    // GET BY ID
    // =========================
    @Test
    void testGetAppointmentById() {

        Appointment appointment = new Appointment();

        appointment.setDescription("Get By ID Test");
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


        Appointment savedAppointment =
                appointmentRepo.save(appointment);

        Long id = savedAppointment.getId();


        Optional<Appointment> result =
                appointmentRepo.findById(id);


        assertThat(result).isPresent();
        assertThat(result.get().getId())
                .isEqualTo(id);
        assertThat(result.get().getDepartment())
                .isEqualTo("Cardiology");
    }


    // =========================
    // UPDATE
    // =========================
    @Test
    void testUpdateAppointment() {

        Appointment appointment = new Appointment();

        appointment.setDescription("Old Description");
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


        Appointment savedAppointment =
                appointmentRepo.save(appointment);


        savedAppointment.setDescription("Updated Description");
        savedAppointment.setDepartment("Neurology");
        savedAppointment.setRoomNumber("B-202");


        Appointment updatedAppointment =
                appointmentRepo.save(savedAppointment);


        assertThat(updatedAppointment.getDescription())
                .isEqualTo("Updated Description");

        assertThat(updatedAppointment.getDepartment())
                .isEqualTo("Neurology");

        assertThat(updatedAppointment.getRoomNumber())
                .isEqualTo("B-202");
    }


    // =========================
    // DELETE
    // =========================
    @Test
    void testDeleteAppointment() {

        Appointment appointment = new Appointment();

        appointment.setDescription("Delete Test");
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


        Appointment savedAppointment =
                appointmentRepo.save(appointment);

        Long id = savedAppointment.getId();


        appointmentRepo.deleteById(id);


        Optional<Appointment> result =
                appointmentRepo.findById(id);

        assertThat(result).isEmpty();
    }
}