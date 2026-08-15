package com.example.controller;


import com.example.entity.Appointment;
import com.example.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping("/save")
    public Appointment saveAppointment(@RequestBody Appointment appointment){

        return appointmentService.save(appointment);
    }

    @GetMapping("/get")
   public List<Appointment> getAppointment(){

        return appointmentService.getAll();
    }


    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id){
        return appointmentService.findById(id);
    }

    @PutMapping("/{id}")
    public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment){
        return appointmentService.update(appointment, id);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointmentById(@PathVariable Long id){
        appointmentService.delete(id);
    }
}
