package com.visith.labappointmentsystem.controller;


import com.visith.labappointmentsystem.model.Inquiry;
import com.visith.labappointmentsystem.model.Review;
import com.visith.labappointmentsystem.service.InquiryService;
import com.visith.labappointmentsystem.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
@CrossOrigin(origins = "http://localhost:3000")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/add")
    public String add(@RequestBody Review review){
        reviewService.saveReview(review);
        return "New Review added";
    }

    @GetMapping("/getAll")
    public List<Review> getAllReviews(){
        return reviewService.getAllReviews();
    }
}
