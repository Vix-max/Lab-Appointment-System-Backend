package com.visith.labappointmentsystem.repository;

import com.visith.labappointmentsystem.model.Admin;
import com.visith.labappointmentsystem.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    Patient findByUsername(String username);

    Optional<Patient> findById(Integer id); // Add findById method



}
