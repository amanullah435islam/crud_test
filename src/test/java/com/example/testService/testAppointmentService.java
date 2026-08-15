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
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;




//@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
public class testAppointmentService {

    @Mock
    private AppointmentRepo appointmentRepo;

    @InjectMocks
    private AppointmentServiceImp appointmentService;


    @Test
    void testSaveAppointment(){
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

        // Mock repository
        when(appointmentRepo.save(any(Appointment.class)))
                .thenReturn(appointment);

        // Call SERVICE method
        Appointment savedAppointment =
                appointmentService.save(appointment);

        // Assertions
        assertThat(savedAppointment).isNotNull();
        assertThat(savedAppointment.getDepartment())
                .isEqualTo("test department");
        assertThat(savedAppointment.getDescription())
                .isEqualTo("test appointment");

    }
}
