package com.visith.labappointmentsystem.repository;

import com.visith.labappointmentsystem.model.Admin;
import com.visith.labappointmentsystem.model.Doctor;
import com.visith.labappointmentsystem.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    Optional<Doctor> findById(Integer id); // Add findById method

    Doctor findByUsername(String username);
}
