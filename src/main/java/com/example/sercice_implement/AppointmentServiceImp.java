package com.example.sercice_implement;

import com.example.entity.Appointment;
import com.example.repo.AppointmentRepo;
import com.example.service.AppointmentService;
import com.example.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;



@Service
@RequiredArgsConstructor
public class AppointmentServiceImp implements AppointmentService {

    private final AppointmentRepo appointmentRepo;


    @Override
    public Appointment Save(Appointment appointment) {
        return appointmentRepo.save(appointment);
    }

    @Override
    public List<Appointment> getAll() {
        return appointmentRepo.findAll();
    }

    @Override
    public Appointment findById(Long id) {

        return appointmentRepo.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Appointment with id: " + id + " not found!"));
    }

    @Override
    public Appointment Update(Appointment appointment, Long id) {

        Appointment a = appointmentRepo.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Appointment with id: " + id + " not found!"));

        a.setDepartment(appointment.getDepartment());
        a.setStartTime(appointment.getStartTime());
        a.setEndTime(appointment.getEndTime());
        a.setDescription(appointment.getDescription());
        a.setRoom(appointment.getRoom());
        a.setRoomType(appointment.getRoomType());
        a.setRoomNumber(appointment.getRoomNumber());
        a.setRoomStatus(appointment.getRoomStatus());

        return appointmentRepo.save(a);
    }


    @Override
    public void delete(Long id) {

        Appointment a = appointmentRepo.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Appointment with id: " + id + " not found!"));
        appointmentRepo.delete(a);
    }
}
