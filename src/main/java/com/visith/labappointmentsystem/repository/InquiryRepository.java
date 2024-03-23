package com.visith.labappointmentsystem.repository;

import com.visith.labappointmentsystem.model.Doctor;
import com.visith.labappointmentsystem.model.Inquiry;
import com.visith.labappointmentsystem.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry, Integer> {

    Optional<Inquiry> findById(Integer id);
}
