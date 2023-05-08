package com.adminportal.services;

import com.adminportal.dao.StudentDAO;
import com.adminportal.entity.Student;
import com.adminportal.services.StudentService;
import java.util.List;
import javax.transaction.Transactional;

public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO;

    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    @Transactional
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    @Transactional
    public Student findById(Long id) {
        return studentDAO.findById(id);
    }

    @Override
    @Transactional
    public void save(Student student) {
        studentDAO.save(student);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        studentDAO.deleteById(id);
    }
}

