package com.visith.labappointmentsystem.service;

import com.visith.labappointmentsystem.model.Inquiry;
import com.visith.labappointmentsystem.model.Review;
import com.visith.labappointmentsystem.repository.InquiryRepository;
import com.visith.labappointmentsystem.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImp implements ReviewService{

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }
}
