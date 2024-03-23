package com.visith.labappointmentsystem.controller;


import com.visith.labappointmentsystem.model.Patient;
import com.visith.labappointmentsystem.model.Payment;
import com.visith.labappointmentsystem.service.PatientService;
import com.visith.labappointmentsystem.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "http://localhost:3000")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    @PostMapping("/add")
    public String add(@RequestBody Payment payment){
        paymentService.savePayment(payment);
        return "New Payment details added";
    }
}
