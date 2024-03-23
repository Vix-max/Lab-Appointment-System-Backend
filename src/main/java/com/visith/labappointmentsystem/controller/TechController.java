package com.visith.labappointmentsystem.controller;

import com.visith.labappointmentsystem.model.Doctor;
import com.visith.labappointmentsystem.model.Tech;
import com.visith.labappointmentsystem.service.TechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tech")
@CrossOrigin(origins = "http://localhost:3000")
public class TechController {

    @Autowired
    private TechService techService;

    @PostMapping("/add")
    public String add(@RequestBody Tech tech){
        techService.saveTech(tech);
        return "New Technician added";
    }

    @GetMapping("/latestId")
    public int getLatestTechId() {
        return techService.getLatestTechId();
    }

    @GetMapping("/getAll")
    public List<Tech> getAllTechs(){
        return techService.getAllTechs();
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.PUT})
    public ResponseEntity<?> deleteTech(@PathVariable Integer id) {
        try {
            techService.deleteTechById(id);
            return ResponseEntity.ok("Technician deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting technician.");
        }
    }


    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<?> login(@RequestBody Tech loginUser) {
        Tech user = techService.findByUsername(loginUser.getUsername());
        if (user != null && user.getPassword().equals(loginUser.getPassword())) {
            // Implement JWT token generation and return it in the response
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/getByUsername/{username}")
    @CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET})
    public ResponseEntity<?> getTechByUsername(@PathVariable String username) {
        try {
            Tech tech = techService.findByUsername(username);
            return ResponseEntity.ok(tech);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving patient details.");
        }
    }


    @PutMapping("/updateUsername")
    @CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.PUT})
    public ResponseEntity<?> updateUsername(@RequestBody Map<String, String> updateInfo) {
        String username = updateInfo.get("username");
        String newUsername = updateInfo.get("newUsername");

        Tech tech = techService.updateUsername(username, newUsername);
        if (tech != null) {
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

        Tech tech = techService.updatePassword(username, newPassword);
        if (tech != null) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    @CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.PUT})
    public ResponseEntity<?> updateTechDetails(@PathVariable Integer id, @RequestBody Tech updateTech) {
        try {
            Tech tech = techService.updateTechDetails(id, updateTech);
            return ResponseEntity.ok(tech);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating patient details.");
        }
    }
}
