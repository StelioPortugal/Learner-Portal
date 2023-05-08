package com.adminportal.servlet;

import com.adminportal.entity.Subject;
import com.adminportal.services.SubjectService;
import com.adminportal.services.SubjectServiceImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SubjectServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private SubjectService subjectService = new SubjectServiceImpl();
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
                deleteSubject(request, response);
                break;
            case "list":
            default:
                listSubjects(request, response);
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
                insertSubject(request, response);
                break;
            case "edit":
                updateSubject(request, response);
                break;
            default:
                listSubjects(request, response);
                break;
        }
    }

    private void listSubjects(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Subject> subjectList = subjectService.findAll();
        request.setAttribute("subjectList", subjectList);
        request.getRequestDispatcher("subject_list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("subject_form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Subject existingSubject = subjectService.findById(id);
        request.setAttribute("subject", existingSubject);
        request.getRequestDispatcher("subject_form.jsp").forward(request, response);
    }

    private void insertSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String subjectName = request.getParameter("subjectName");

        Subject newSubject = new Subject(subjectName);
        subjectService.save(newSubject);
        response.sendRedirect("SubjectServlet?action=list");
    }

    private void updateSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String subjectName = request.getParameter("subjectName");

        Subject updatedSubject = new Subject(id, subjectName);
        subjectService.save(updatedSubject);
        response.sendRedirect("SubjectServlet?action=list");
    }

    private void deleteSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        subjectService.deleteById(id);
        response.sendRedirect("SubjectServlet?action=list");
    }

}
