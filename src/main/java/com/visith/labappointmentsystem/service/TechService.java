package com.visith.labappointmentsystem.service;


import com.visith.labappointmentsystem.model.Doctor;
import com.visith.labappointmentsystem.model.Tech;

import java.util.List;
import java.util.Optional;

public interface TechService {
    public Tech saveTech(Tech tech);

    int getLatestTechId();

    public List<Tech> getAllTechs();

    Optional<Tech> findById(Integer id);

    void deleteTechById(Integer id);

    public Tech findByUsername(String username);

    public Tech updateTechDetails(Integer id, Tech updatedTech);

    public Tech updateUsername(String username, String newUsername);

    public Tech updatePassword(String username, String newPassword);

}
