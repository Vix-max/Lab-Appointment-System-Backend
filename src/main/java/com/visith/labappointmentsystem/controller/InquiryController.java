package com.visith.labappointmentsystem.controller;


import com.visith.labappointmentsystem.model.Doctor;
import com.visith.labappointmentsystem.model.Inquiry;
import com.visith.labappointmentsystem.service.DoctorService;
import com.visith.labappointmentsystem.service.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inquiry")
@CrossOrigin(origins = "http://localhost:3000")
public class InquiryController {

    @Autowired
    private InquiryService inquiryService;

    @PostMapping("/add")
    public String add(@RequestBody Inquiry inquiry){
        inquiryService.saveInquiry(inquiry);
        return "New Inquiry added";
    }

    @GetMapping("/getAll")
    public List<Inquiry> getAllInquiries(){
        return inquiryService.getAllInquiries();
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.PUT})
    public ResponseEntity<?> deleteInquiry(@PathVariable Integer id) {
        try {
            inquiryService.deleteInquiryById(id);
            return ResponseEntity.ok("Inquiry deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting inquiry.");
        }
    }
}
