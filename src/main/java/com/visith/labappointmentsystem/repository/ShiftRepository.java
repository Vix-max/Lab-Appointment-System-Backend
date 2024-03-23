package com.visith.labappointmentsystem.repository;

import com.visith.labappointmentsystem.model.Shift;
import com.visith.labappointmentsystem.model.Tech;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, Integer> {

    List<Shift> findByTechId(Integer techId); // New method declaration







}
