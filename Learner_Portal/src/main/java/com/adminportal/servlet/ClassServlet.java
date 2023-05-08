package com.adminportal.servlet;

import com.adminportal.entity.Class;
import com.adminportal.services.ClassService;
import com.adminportal.services.ClassServiceImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ClassServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ClassService classService = new ClassServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "add":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteClass(request, response);
                break;
            case "list":
            default:
                listClasses(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "add":
                insertClass(request, response);
                break;
            case "edit":
                updateClass(request, response);
                break;
            default:
                listClasses(request, response);
                break;
        }
    }

    private void listClasses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Class> classList = classService.findAll();
        request.setAttribute("classList", classList);
        request.getRequestDispatcher("class_list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("class_form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Class existingClass = classService.findById(id);
        request.setAttribute("class", existingClass);
        request.getRequestDispatcher("class_form.jsp").forward(request, response);
    }

    private void insertClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String className = request.getParameter("className");

        Class newClass = new Class(className);
        classService.save(newClass);
        response.sendRedirect("ClassServlet?action=list");
    }

    private void updateClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String className = request.getParameter("className");

        Class updatedClass = new Class(id, className);
        classService.save(updatedClass);
        response.sendRedirect("ClassServlet?action=list");
    }

    private void deleteClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        classService.deleteById(id);
        response.sendRedirect("ClassServlet?action=list");
    }
}
