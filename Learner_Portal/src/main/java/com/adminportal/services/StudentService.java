package com.adminportal.services;

import java.util.List;

import com.adminportal.entity.Student;

public interface StudentService {
    List<Student> findAll();
    Student findById(Long id);
    void save(Student student);
    void deleteById(Long id);
}
