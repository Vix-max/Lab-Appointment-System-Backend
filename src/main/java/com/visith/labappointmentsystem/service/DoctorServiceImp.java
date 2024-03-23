package com.visith.labappointmentsystem.service;

import com.visith.labappointmentsystem.model.Admin;
import com.visith.labappointmentsystem.model.Doctor;
import com.visith.labappointmentsystem.model.Patient;
import com.visith.labappointmentsystem.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImp implements DoctorService{

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Optional<Doctor> findById(Integer id) {
        return doctorRepository.findById(id);
    }

    @Override
    public void deleteDoctorById(Integer id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public Doctor findByUsername(String username) {
        return doctorRepository.findByUsername(username);
    }

    @Override
    public Doctor updateUsername(String username, String newUsername) {
        Doctor doctor = doctorRepository.findByUsername(username);
        if (doctor != null) {
            doctor.setUsername(newUsername);
            return doctorRepository.save(doctor);
        }
        return null; // or throw an exception
    }

    @Override
    public Doctor updatePassword(String username, String newPassword) {
        Doctor doctor = doctorRepository.findByUsername(username);
        if (doctor != null) {
            doctor.setPassword(newPassword);
            return doctorRepository.save(doctor);
        }
        return null; // or throw an exception
    }

    @Override
    public Doctor updateDoctorDetails(Integer id, Doctor updatedDoctor) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        if (optionalDoctor.isPresent()) {
            Doctor doctor = optionalDoctor.get();
            doctor.setFullName(updatedDoctor.getFullName());
            doctor.setSpecial(updatedDoctor.getSpecial());
            doctor.setHospital(updatedDoctor.getHospital());
            doctor.setEmail(updatedDoctor.getEmail());
            doctor.setMobileNumber(updatedDoctor.getMobileNumber());
            return doctorRepository.save(doctor);
        } else {
            throw new IllegalArgumentException("Doctor with ID " + id + " not found.");
        }
    }
}
