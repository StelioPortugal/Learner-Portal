package com.adminportal.services;

import com.adminportal.dao.AdminDAO;
import com.adminportal.entity.Admin;

public class AdminServiceImpl implements AdminService {

    private AdminDAO adminDAO;

    public AdminServiceImpl(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    @Override
    public Admin findByUsername(String username) {
        return adminDAO.findAdminByUsername(username);
    }

    @Override
    public Admin saveAdmin(Admin admin) {
        return adminDAO.saveAdmin(admin); // Updated method name
    }
    
    @Override
    public boolean adminExistsByUsername(String username) {
        return adminDAO.existsAdminByUsername(username); // Updated method name
    }
    
    @Override
    public boolean authenticateAdmin(String username, String password) {
        Admin admin = adminDAO.findAdminByUsername(username);
        if (admin != null && admin.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
