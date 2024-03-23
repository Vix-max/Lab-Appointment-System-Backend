package com.visith.labappointmentsystem.service;

import com.visith.labappointmentsystem.model.Admin;
import com.visith.labappointmentsystem.model.Patient;
import com.visith.labappointmentsystem.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImp implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin saveAdmin(Admin admin) {

        return adminRepository.save(admin);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    @Override
    public Admin updateUsername(String username, String newUsername) {
        Admin admin = adminRepository.findByUsername(username);
        if (admin != null) {
            admin.setUsername(newUsername);
            return adminRepository.save(admin);
        }
        return null; // or throw an exception
    }

    @Override
    public Admin updatePassword(String username, String newPassword) {
        Admin admin = adminRepository.findByUsername(username);
        if (admin != null) {
            admin.setPassword(newPassword);
            return adminRepository.save(admin);
        }
        return null; // or throw an exception
    }

    @Override
    public void deleteAdmin(String username) {
        Admin admin = adminRepository.findByUsername(username);
        if (admin != null) {
            adminRepository.delete(admin);
        } else {
            // Handle if admin is not found
        }
    }


}
