package com.visith.labappointmentsystem.service;

import com.visith.labappointmentsystem.model.Inquiry;
import com.visith.labappointmentsystem.model.Review;

import java.util.List;

public interface ReviewService {

    public Review saveReview(Review review);

    public List<Review> getAllReviews();
}
