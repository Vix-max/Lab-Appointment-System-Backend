package com.visith.labappointmentsystem.service;

import com.visith.labappointmentsystem.model.Doctor;
import com.visith.labappointmentsystem.model.Inquiry;
import com.visith.labappointmentsystem.model.Patient;

import java.util.List;
import java.util.Optional;

public interface InquiryService {

    public Inquiry saveInquiry(Inquiry inquiry);

    public List<Inquiry> getAllInquiries();

    Optional<Inquiry> findById(Integer id);

    void deleteInquiryById(Integer id);
}
