package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private  String Department;
    private  String Room;
    private  String RoomType;
    private  String RoomNumber;
    private  String RoomStatus;
    

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

}
