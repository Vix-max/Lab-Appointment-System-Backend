package com.visith.labappointmentsystem.controller;


import com.visith.labappointmentsystem.model.Shift;
import com.visith.labappointmentsystem.model.Tech;
import com.visith.labappointmentsystem.service.ShiftService;
import com.visith.labappointmentsystem.service.TechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/shift")
@CrossOrigin(origins = "http://localhost:3000")
public class ShiftController {

    @Autowired
    private ShiftService shiftService;

    @PostMapping("/add")
    public Shift add(@RequestBody Shift shift){
        Shift savedShift = shiftService.saveShift(shift);
        System.out.println("Saved Shift ID: " + savedShift.getId()); // Log the saved Shift ID

        // Add the ID to the savedShift object before returning
        savedShift.setId(savedShift.getId()); // Assuming getId() returns the ID

        return savedShift;
    }

    @DeleteMapping("/deleteByTechId/{techId}")
    public ResponseEntity<?> deleteShiftsByTechId(@PathVariable Integer techId) {
        try {
            shiftService.deleteShiftsByTechId(techId);
            return ResponseEntity.ok("Shifts for Tech ID " + techId + " deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting shifts for Tech ID " + techId + ".");
        }
    }


    // Endpoint to retrieve shifts by techId
    @GetMapping("/getByTechId/{techId}")
    public ResponseEntity<List<Shift>> getShiftsByTechId(@PathVariable Integer techId) {
        try {
            List<Shift> shifts = shiftService.getShiftsByTechId(techId);
            if (shifts.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(shifts);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }










}
