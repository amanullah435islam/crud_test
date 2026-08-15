package com.example.testRepo;

import com.example.entity.Appointment;
import com.example.repo.AppointmentRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.mail.javamail.JavaMailSender;   //very very important
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import java.time.LocalDateTime;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class testAppointment {

    @Autowired
    private AppointmentRepo appointmentRepo;

    @MockitoBean
    private JavaMailSender javaMailSender;

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
        appointment.setRoomStatus("test room status");

        Appointment saveAppointmen = appointmentRepo.save(appointment);

        assertThat(saveAppointmen).isNotNull();
        assertThat(saveAppointmen.getId()).isNotNull();
        assertThat(saveAppointmen.getDepartment()).isEqualTo("test department");
    }
}
