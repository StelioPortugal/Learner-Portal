package com.adminportal.dao;

import com.adminportal.entity.Admin;

public interface AdminDAO {
    Admin findAdminByUsername(String username);
    Admin saveAdmin(Admin admin);
    boolean existsAdminByUsername(String username);
}