package com.adminportal.servlet;

import com.adminportal.dao.AdminDAO;
import com.adminportal.dao.AdminDAOImpl;
import com.adminportal.entity.Admin;
import com.adminportal.services.AdminService;
import com.adminportal.services.AdminServiceImpl;
import com.adminportal.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AdminService adminService;

    @Override
    public void init() throws ServletException {
        super.init();
        EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AdminDAO adminDAO = new AdminDAOImpl(entityManager);
        adminService = new AdminServiceImpl(adminDAO);

        // Check if an admin with the default username "admin" exists
        if (!adminService.adminExistsByUsername("admin")) {
            // If not, create one
            Admin defaultAdmin = new Admin();
            defaultAdmin.setUsername("admin");
            defaultAdmin.setPassword("admin");
            adminService.saveAdmin(defaultAdmin);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("admin_login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("login".equals(action)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (adminService.authenticateAdmin(username, password)) {
                request.getSession().setAttribute("admin", username);
                response.sendRedirect("dashboard.jsp");
            } else {
                request.setAttribute("error", "Invalid username or password");
                request.getRequestDispatcher("admin_login.jsp").forward(request, response);
            }
        }
    }

    @Override
    public void destroy() {
        JPAUtil.shutdown();
        super.destroy();
    }
}
