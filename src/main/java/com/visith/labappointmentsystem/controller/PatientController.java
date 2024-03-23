package com.visith.labappointmentsystem.controller;

import com.visith.labappointmentsystem.model.Admin;
import com.visith.labappointmentsystem.model.Patient;
import com.visith.labappointmentsystem.service.AdminService;
import com.visith.labappointmentsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/patient")
@CrossOrigin(origins = "http://localhost:3000")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/add")
    public String add(@RequestBody Patient patient){
        patientService.savePatient(patient);
        return "New Patient added";
    }

    @GetMapping("/getAll")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<?> login(@RequestBody Patient loginUser) {
        Patient user = patientService.findByUsername(loginUser.getUsername());
        if (user != null && user.getPassword().equals(loginUser.getPassword())) {
            // Implement JWT token generation and return it in the response
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PutMapping("/updateUsername")
    @CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.PUT})
    public ResponseEntity<?> updateUsername(@RequestBody Map<String, String> updateInfo) {
        String username = updateInfo.get("username");
        String newUsername = updateInfo.get("newUsername");

        Patient patient = patientService.updateUsername(username, newUsername);
        if (patient != null) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updatePassword")
    @CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.PUT})
    public ResponseEntity<?> updatePassword(@RequestBody Map<String, String> updateInfo) {
        String username = updateInfo.get("username");
        String newPassword = updateInfo.get("newPassword");

        Patient patient = patientService.updatePassword(username, newPassword);
        if (patient != null) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.PUT})
    public ResponseEntity<?> deletePatient(@PathVariable Integer id) {
        try {
            patientService.deletePatientById(id);
            return ResponseEntity.ok("Patient deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting patient.");
        }
    }

    @PutMapping("/update/{id}")
    @CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.PUT})
    public ResponseEntity<?> updatePatientDetails(@PathVariable Integer id, @RequestBody Patient updatedPatient) {
        try {
            Patient patient = patientService.updatePatientDetails(id, updatedPatient);
            return ResponseEntity.ok(patient);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating patient details.");
        }
    }


    @GetMapping("/getByUsername/{username}")
    @CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET})
    public ResponseEntity<?> getPatientByUsername(@PathVariable String username) {
        try {
            Patient patient = patientService.findByUsername(username);
            return ResponseEntity.ok(patient);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving patient details.");
        }
    }






}
