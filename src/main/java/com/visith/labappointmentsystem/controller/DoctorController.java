package com.visith.labappointmentsystem.controller;


import com.visith.labappointmentsystem.model.Admin;
import com.visith.labappointmentsystem.model.Doctor;
import com.visith.labappointmentsystem.model.Patient;
import com.visith.labappointmentsystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/doctor")
@CrossOrigin(origins = "http://localhost:3000")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/add")
    public String add(@RequestBody Doctor doctor){
        doctorService.saveDoctor(doctor);
        return "New Doctor added";
    }

    @GetMapping("/getAll")
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.PUT})
    public ResponseEntity<?> deleteDoctor(@PathVariable Integer id) {
        try {
            doctorService.deleteDoctorById(id);
            return ResponseEntity.ok("Doctor deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting doctor.");
        }
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<?> login(@RequestBody Doctor loginUser) {
        Doctor user = doctorService.findByUsername(loginUser.getUsername());
        if (user != null && user.getPassword().equals(loginUser.getPassword())) {
            // Implement JWT token generation and return it in the response
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/getByUsername/{username}")
    @CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET})
    public ResponseEntity<?> getDoctorByUsername(@PathVariable String username) {
        try {
            Doctor doctor = doctorService.findByUsername(username);
            return ResponseEntity.ok(doctor);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving patient details.");
        }
    }


    @PutMapping("/updateUsername")
    @CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.PUT})
    public ResponseEntity<?> updateUsername(@RequestBody Map<String, String> updateInfo) {
        String username = updateInfo.get("username");
        String newUsername = updateInfo.get("newUsername");

        Doctor doctor = doctorService.updateUsername(username, newUsername);
        if (doctor != null) {
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

        Doctor doctor = doctorService.updatePassword(username, newPassword);
        if (doctor != null) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    @CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.PUT})
    public ResponseEntity<?> updateDoctorDetails(@PathVariable Integer id, @RequestBody Doctor updateDoctor) {
        try {
            Doctor doctor = doctorService.updateDoctorDetails(id, updateDoctor);
            return ResponseEntity.ok(doctor);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating patient details.");
        }
    }

}
