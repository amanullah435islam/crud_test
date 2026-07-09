package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Doctor;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long>{

}
