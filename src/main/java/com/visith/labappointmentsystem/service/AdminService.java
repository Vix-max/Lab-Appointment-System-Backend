package com.visith.labappointmentsystem.service;

import com.visith.labappointmentsystem.model.Admin;
import com.visith.labappointmentsystem.model.Patient;

import java.util.List;


public interface AdminService {

    public Admin saveAdmin(Admin admin);
    public List<Admin> getAllAdmins();

    public Admin findByUsername(String username);

    public Admin updateUsername(String username, String newUsername);

    public Admin updatePassword(String username, String newPassword);

    public void deleteAdmin(String username);



}
