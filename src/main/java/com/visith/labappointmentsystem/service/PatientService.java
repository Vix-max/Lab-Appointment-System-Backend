package com.visith.labappointmentsystem.service;

import com.visith.labappointmentsystem.model.Admin;
import com.visith.labappointmentsystem.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    public Patient savePatient(Patient patient);

    public List<Patient> getAllPatients();

    public Patient findByUsername(String username);

    public Patient updateUsername(String username, String newUsername);

    public Patient updatePassword(String username, String newPassword);

    Optional<Patient> findById(Integer id);

    void deletePatientById(Integer id);

    public Patient updatePatientDetails(Integer id, Patient updatedPatient);

}
