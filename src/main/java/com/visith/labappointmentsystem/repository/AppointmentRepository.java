package com.visith.labappointmentsystem.repository;

import com.visith.labappointmentsystem.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    Appointment findTopByOrderByIdDesc();

    List<Appointment> findByUsername(String username);

    List<Appointment> findByDate(String date);
}
