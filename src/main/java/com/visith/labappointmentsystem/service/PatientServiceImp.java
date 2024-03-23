package com.visith.labappointmentsystem.service;

import com.visith.labappointmentsystem.model.Admin;
import com.visith.labappointmentsystem.model.Patient;
import com.visith.labappointmentsystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImp implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient findByUsername(String username) {
        return patientRepository.findByUsername(username);
    }

    @Override
    public Optional<Patient> findById(Integer id) {
        return patientRepository.findById(id);
    }


    @Override
    public Patient updateUsername(String username, String newUsername) {
        Patient patient = patientRepository.findByUsername(username);
        if (patient != null) {
            patient.setUsername(newUsername);
            return patientRepository.save(patient);
        }
        return null; // or throw an exception
    }

    @Override
    public Patient updatePassword(String username, String newPassword) {
        Patient patient = patientRepository.findByUsername(username);
        if (patient != null) {
            patient.setPassword(newPassword);
            return patientRepository.save(patient);
        }
        return null; // or throw an exception
    }

    @Override
    public void deletePatientById(Integer id) {
        patientRepository.deleteById(id);
    }

    @Override
    public Patient updatePatientDetails(Integer id, Patient updatedPatient) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            patient.setFullName(updatedPatient.getFullName());
            patient.setAge(updatedPatient.getAge());
            patient.setMobileNumber(updatedPatient.getMobileNumber());
            patient.setEmail(updatedPatient.getEmail());
            return patientRepository.save(patient);
        } else {
            throw new IllegalArgumentException("Patient with ID " + id + " not found.");
        }
    }
}
