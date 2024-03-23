package com.visith.labappointmentsystem.service;

import com.visith.labappointmentsystem.model.Doctor;
import com.visith.labappointmentsystem.model.Inquiry;
import com.visith.labappointmentsystem.model.Patient;
import com.visith.labappointmentsystem.repository.DoctorRepository;
import com.visith.labappointmentsystem.repository.InquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InquiryServiceImp implements InquiryService{

    @Autowired
    private InquiryRepository inquiryRepository;

    @Override
    public Inquiry saveInquiry(Inquiry inquiry) {
        return inquiryRepository.save(inquiry);
    }

    @Override
    public List<Inquiry> getAllInquiries() {
        return inquiryRepository.findAll();
    }

    @Override
    public Optional<Inquiry> findById(Integer id) {
        return inquiryRepository.findById(id);
    }

    @Override
    public void deleteInquiryById(Integer id) {
        inquiryRepository.deleteById(id);
    }
}
