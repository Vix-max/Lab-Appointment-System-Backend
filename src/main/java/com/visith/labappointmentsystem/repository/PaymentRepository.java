package com.visith.labappointmentsystem.repository;

import com.visith.labappointmentsystem.model.Patient;
import com.visith.labappointmentsystem.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
