package com.visith.labappointmentsystem.controller;

import com.visith.labappointmentsystem.model.Admin;
import com.visith.labappointmentsystem.model.Appointment;
import com.visith.labappointmentsystem.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/appointment")
@CrossOrigin(origins = "http://localhost:3000")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/add")
    public ResponseEntity<String> addAppointment(
            @RequestParam("selectedTest") String selectedTest,
            @RequestParam("reason") String reason,
            @RequestParam("description") String description,
            @RequestParam("selectedDoctor") String selectedDoctor,
            @RequestParam("selectedDate") String selectedDate,
            @RequestParam("selectedTime") String selectedTime,
            @RequestParam("selectedPaymentMethod") String selectedPaymentMethod,
            @RequestParam("username") String username,
            @RequestParam("file") MultipartFile report
    ) {
        try {
            // Create an Appointment object
            Appointment appointment = new Appointment();
            appointment.setTest(selectedTest);
            appointment.setReason(reason);
            appointment.setDescription(description);
            appointment.setDoctor(selectedDoctor);
            appointment.setDate(selectedDate);
            appointment.setTime(selectedTime);
            appointment.setPayment(selectedPaymentMethod);
            appointment.setUsername(username);
            appointment.setReport(report.getBytes()); // Convert file to byte array and save in the Appointment object

            // Save the appointment
            appointmentService.saveAppointment(appointment);

            return ResponseEntity.ok("New Appointment added");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while processing the file");
        }
    }

    @GetMapping("/latest")
    public ResponseEntity<Appointment> getLatestAppointment() {
        try {
            Appointment latestAppointment = appointmentService.getLatestAppointment();
            if (latestAppointment != null) {
                return ResponseEntity.ok(latestAppointment);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<List<Appointment>> getAppointmentsByUsername(@PathVariable String username) {
        List<Appointment> appointments = appointmentService.getAppointmentsByUsername(username);
        if (appointments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @GetMapping("/getByDate/{date}")
    public ResponseEntity<List<Appointment>> getAppointmentsByDate(@PathVariable String date) {
        try {
            List<Appointment> appointments = appointmentService.getAppointmentsByDate(date);
            return ResponseEntity.ok(appointments);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/getAll")
    public List<Appointment> getAllAppointments(){
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/report/{id}")
    public ResponseEntity<byte[]> downloadAppointmentReport(@PathVariable int id) {
        try {
            byte[] reportData = appointmentService.getAppointmentReport(id);
            if (reportData != null) {
                return ResponseEntity.ok()
                        .header("Content-Disposition", "attachment; filename=report.pdf")
                        .body(reportData);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/{id}/uploadResult")
    public ResponseEntity<String> uploadTestResult(@PathVariable int id, @RequestParam("file") MultipartFile file) {
        try {
            byte[] fileData = file.getBytes();
            appointmentService.uploadTestResult(id, fileData);
            return ResponseEntity.ok("Test result uploaded successfully");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while processing the file");
        }
    }


    @GetMapping("/result/{id}")
    public ResponseEntity<byte[]> downloadAppointmentResult(@PathVariable int id) {
        try {
            byte[] resultData = appointmentService.getAppointmentResult(id);
            if (resultData != null) {
                return ResponseEntity.ok()
                        .header("Content-Disposition", "attachment; filename=Test_Result.pdf")
                        .body(resultData);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
