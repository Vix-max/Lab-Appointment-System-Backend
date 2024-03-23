package com.visith.labappointmentsystem.repository;

import com.visith.labappointmentsystem.model.Inquiry;
import com.visith.labappointmentsystem.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
