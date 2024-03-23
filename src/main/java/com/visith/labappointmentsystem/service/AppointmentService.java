package com.visith.labappointmentsystem.service;

import com.visith.labappointmentsystem.model.Admin;
import com.visith.labappointmentsystem.model.Appointment;
import com.visith.labappointmentsystem.model.Doctor;

import java.io.IOException;
import java.util.List;

public interface AppointmentService {

    public Appointment saveAppointment(Appointment appointment);

    Appointment getLatestAppointment();

    List<Appointment> getAppointmentsByUsername(String username);

    List<Appointment> getAppointmentsByDate(String date);

    public List<Appointment> getAllAppointments();

    byte[] getAppointmentReport(int appointmentId);

    byte[] getAppointmentResult(int appointmentId);

    void uploadTestResult(int appointmentId, byte[] fileData) throws IOException;
}
