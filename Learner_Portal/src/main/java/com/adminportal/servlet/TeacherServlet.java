package com.adminportal.servlet;

import com.adminportal.entity.Teacher;
import com.adminportal.services.TeacherService;
import com.adminportal.services.TeacherServiceImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TeacherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private TeacherService teacherService = new TeacherServiceImpl();

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
                deleteTeacher(request, response);
                break;
            case "list":
            default:
                listTeachers(request, response);
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
                insertTeacher(request, response);
                break;
            case "edit":
                updateTeacher(request, response);
                break;
            default:
                listTeachers(request, response);
                break;
        }
    }

    private void listTeachers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Teacher> teacherList = teacherService.findAll();
        request.setAttribute("teacherList", teacherList);
        request.getRequestDispatcher("teacher_list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("teacher_form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Teacher existingTeacher = teacherService.findById(id);
        request.setAttribute("teacher", existingTeacher);
        request.getRequestDispatcher("teacher_form.jsp").forward(request, response);
    }

    private void insertTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        Teacher newTeacher = new Teacher(name, email);
        teacherService.save(newTeacher);
        response.sendRedirect("TeacherServlet?action=list");
    }

    private void updateTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        Teacher updatedTeacher = new Teacher(id, name, email);
        teacherService.save(updatedTeacher);
        response.sendRedirect("TeacherServlet?action=list");
    }

    private void deleteTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        teacherService.deleteById(id);
        response.sendRedirect("TeacherServlet?action=list");
    }
}
