package com.visith.labappointmentsystem.service;

import com.visith.labappointmentsystem.model.Doctor;
import com.visith.labappointmentsystem.model.Patient;
import com.visith.labappointmentsystem.model.Tech;
import com.visith.labappointmentsystem.repository.TechRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechServiceImp implements TechService {

    @Autowired
    private TechRepository techRepository;

    @Override
    public Tech saveTech(Tech tech) {
        return techRepository.save(tech);
    }

    @Override
    public int getLatestTechId() {
        Tech latestTech = techRepository.findFirstByOrderByIdDesc();
        return latestTech != null ? latestTech.getId() : -1;
    }

    @Override
    public List<Tech> getAllTechs() {
        return techRepository.findAll();
    }

    @Override
    public Optional<Tech> findById(Integer id) {
        return techRepository.findById(id);
    }

    @Override
    public void deleteTechById(Integer id) {
        techRepository.deleteById(id);
    }

    @Override
    public Tech findByUsername(String username) {
        return techRepository.findByUsername(username);
    }


    @Override
    public Tech updateUsername(String username, String newUsername) {
        Tech tech = techRepository.findByUsername(username);
        if (tech != null) {
            tech.setUsername(newUsername);
            return techRepository.save(tech);
        }
        return null; // or throw an exception
    }

    @Override
    public Tech updatePassword(String username, String newPassword) {
        Tech tech = techRepository.findByUsername(username);
        if (tech != null) {
            tech.setPassword(newPassword);
            return techRepository.save(tech);
        }
        return null; // or throw an exception
    }

    @Override
    public Tech updateTechDetails(Integer id, Tech updatedTech) {
        Optional<Tech> optionalTech = techRepository.findById(id);
        if (optionalTech.isPresent()) {
            Tech tech = optionalTech.get();
            tech.setFullName(updatedTech.getFullName());
            tech.setEmpNumber(updatedTech.getEmpNumber());
            tech.setSpecial(updatedTech.getSpecial());
            tech.setEmail(updatedTech.getEmail());
            tech.setMobileNumber(updatedTech.getMobileNumber());
            tech.setAge(updatedTech.getAge());
            return techRepository.save(tech);
        } else {
            throw new IllegalArgumentException("Technician with ID " + id + " not found.");
        }
    }
}
