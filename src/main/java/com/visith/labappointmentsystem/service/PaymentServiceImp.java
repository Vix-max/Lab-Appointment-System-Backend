package com.visith.labappointmentsystem.service;

import com.visith.labappointmentsystem.model.Patient;
import com.visith.labappointmentsystem.model.Payment;
import com.visith.labappointmentsystem.repository.PatientRepository;
import com.visith.labappointmentsystem.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImp implements PaymentService{


    @Autowired
    private PaymentRepository paymentRepository;
    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }
}
