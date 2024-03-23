package com.visith.labappointmentsystem.repository;


import com.visith.labappointmentsystem.model.Doctor;
import com.visith.labappointmentsystem.model.Tech;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TechRepository extends JpaRepository<Tech, Integer> {
        Tech findFirstByOrderByIdDesc();

        Optional<Tech> findById(Integer id); // Add findById method

        Tech findByUsername(String username);


}
