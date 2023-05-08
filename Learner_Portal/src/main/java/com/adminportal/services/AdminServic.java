package com.adminportal.services;

import com.adminportal.dao.AdminDAO;
import com.adminportal.entity.Admin;

public class AdminServic {
    private AdminDAO adminDAO;

    public AdminServic(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    public boolean authenticateAdmin(String username, String password) {
        Admin admin = adminDAO.findAdminByUsername(username);
        if (admin != null && admin.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
