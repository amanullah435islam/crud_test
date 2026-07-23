package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Doctor;

import java.util.Optional;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long>{
    Optional<Doctor> findByUserId(Long userId);
}
