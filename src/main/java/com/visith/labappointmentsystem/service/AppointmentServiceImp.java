package com.visith.labappointmentsystem.service;

import com.visith.labappointmentsystem.model.Admin;
import com.visith.labappointmentsystem.model.Appointment;
import com.visith.labappointmentsystem.model.Doctor;
import com.visith.labappointmentsystem.repository.AppointmentRepository;
import com.visith.labappointmentsystem.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImp implements AppointmentService{

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment getLatestAppointment() {
        return appointmentRepository.findTopByOrderByIdDesc();
    }

    @Override
    public List<Appointment> getAppointmentsByUsername(String username) {
        return appointmentRepository.findByUsername(username);
    }

    @Override
    public List<Appointment> getAppointmentsByDate(String date) {
        return appointmentRepository.findByDate(date);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public byte[] getAppointmentReport(int appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .map(Appointment::getReport)
                .orElse(null);
    }

    @Override
    public byte[] getAppointmentResult(int appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .map(Appointment::getResult)
                .orElse(null);
    }

    @Override
    public void uploadTestResult(int appointmentId, byte[] fileData) throws IOException {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found with ID: " + appointmentId));

        // Set the test result data to the appointment
        appointment.setResult(fileData);

        // Update the status to "Completed"
        appointment.setReportStatus("Completed");

        // Save the appointment with the updated test result and status
        appointmentRepository.save(appointment);
    }
}

