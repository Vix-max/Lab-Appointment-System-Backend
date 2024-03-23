package com.visith.labappointmentsystem.service;

import com.visith.labappointmentsystem.model.Shift;
import com.visith.labappointmentsystem.model.Tech;
import com.visith.labappointmentsystem.repository.ShiftRepository;
import com.visith.labappointmentsystem.repository.TechRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShiftServiceImp implements ShiftService{

    @Autowired
    private ShiftRepository shiftRepository;

    @Override
    public Shift saveShift(Shift shift) {
        return shiftRepository.save(shift);
    }

    @Override
    public void deleteShiftsByTechId(Integer techId) {
        List<Shift> shiftsToDelete = shiftRepository.findByTechId(techId);
        shiftRepository.deleteAll(shiftsToDelete);
    }

    @Override
    public List<Shift> getShiftsByTechId(Integer techId) {
        return shiftRepository.findByTechId(techId);
    }










}
