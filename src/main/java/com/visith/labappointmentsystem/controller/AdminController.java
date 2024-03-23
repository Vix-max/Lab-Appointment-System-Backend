package com.visith.labappointmentsystem.controller;

import com.visith.labappointmentsystem.model.Admin;
import com.visith.labappointmentsystem.model.Patient;
import com.visith.labappointmentsystem.repository.AdminRepository;
import com.visith.labappointmentsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/add")
    public String add(@RequestBody Admin admin){
        adminService.saveAdmin(admin);
        return "New admin added";
    }

    @GetMapping("/getAll")
    public List<Admin> getAllAdmins(){
        return adminService.getAllAdmins();
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<?> login(@RequestBody Admin loginUser) {
        Admin user = adminService.findByUsername(loginUser.getUsername());
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

        Admin admin = adminService.updateUsername(username, newUsername);
        if (admin != null) {
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

        Admin admin = adminService.updatePassword(username, newPassword);
        if (admin != null) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{username}")
    @CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.DELETE})
    public ResponseEntity<?> deleteAdmin(@PathVariable String username) {
        adminService.deleteAdmin(username);
        return ResponseEntity.ok().build();
    }





}
