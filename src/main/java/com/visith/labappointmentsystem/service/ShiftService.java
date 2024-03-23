package com.visith.labappointmentsystem.service;

import com.visith.labappointmentsystem.model.Shift;
import com.visith.labappointmentsystem.model.Tech;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ShiftService {

    public Shift saveShift(Shift shift);
    void deleteShiftsByTechId(Integer techId); // New method declaration

    List<Shift> getShiftsByTechId(Integer techId); // New method declaration





}


