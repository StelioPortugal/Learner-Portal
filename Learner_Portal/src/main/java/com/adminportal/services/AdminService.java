package com.adminportal.services;

import com.adminportal.entity.Admin;

public interface AdminService {
    
    Admin findByUsername(String username);
    
    Admin saveAdmin(Admin admin);
    boolean adminExistsByUsername(String username);
    boolean authenticateAdmin(String username, String password);

}
