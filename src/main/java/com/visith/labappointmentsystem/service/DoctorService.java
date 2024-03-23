package com.visith.labappointmentsystem.service;

import com.visith.labappointmentsystem.model.Admin;
import com.visith.labappointmentsystem.model.Doctor;
import com.visith.labappointmentsystem.model.Patient;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    public Doctor saveDoctor(Doctor doctor);

    public List<Doctor> getAllDoctors();

    Optional<Doctor> findById(Integer id);

    void deleteDoctorById(Integer id);

    public Doctor findByUsername(String username);

    public Doctor updateDoctorDetails(Integer id, Doctor updatedDoctor);

    public Doctor updateUsername(String username, String newUsername);

    public Doctor updatePassword(String username, String newPassword);
}
