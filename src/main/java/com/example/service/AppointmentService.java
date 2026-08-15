package com.example.service;

import com.example.entity.Appointment;
import java.util.List;

public interface AppointmentService {

    Appointment Save(Appointment appointment);
    List<Appointment> getAll();
    Appointment findById(Long id);
    Appointment Update(Appointment appointment, Long id);
    void delete(Long id);
}
