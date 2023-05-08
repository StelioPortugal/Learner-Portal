package com.adminportal.servlet;

import com.adminportal.entity.Student;
import com.adminportal.services.StudentService;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;


public class StudentServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StudentService studentService;

    public StudentServlet(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "add":
            case "update":
                showForm(request, response);
                break;
            case "delete":
                deleteStudent(request, response);
                break;
            case "list":
            default:
                listStudents(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "add":
            case "update":
                saveStudent(request, response);
                break;
            case "list":
            default:
                listStudents(request, response);
                break;
        }
    }

    private void showForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("studentId");
        Student student = null;

        if (studentId != null) {
            student = studentService.findById(Long.parseLong(studentId));
        }

        request.setAttribute("student", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/" + (student == null ? "add_student.jsp" : "edit_student.jsp"));
        dispatcher.forward(request, response);
    }

    private void saveStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("studentId");
        Student student = new Student();
        student.setFirstName(request.getParameter("firstName"));
        student.setLastName(request.getParameter("lastName"));
        student.setEmail(request.getParameter("email"));

        if (studentId == null) {
            studentService.save(student);
        } else {
            student.setId(Long.parseLong(studentId));
            studentService.save(student);
        }

        response.sendRedirect(request.getContextPath() + "/student?action=list");
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("studentId");

        if (studentId != null) {
            studentService.deleteById(Long.parseLong(studentId));
        }

        response.sendRedirect(request.getContextPath() + "/student?action=list");
    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = studentService.findAll();
        request.setAttribute("students", students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/view_students.jsp");
        dispatcher.forward(request, response);
    }
}
