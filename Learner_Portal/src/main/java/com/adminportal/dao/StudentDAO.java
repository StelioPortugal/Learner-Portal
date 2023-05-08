package com.adminportal.dao;

import java.util.List;

import com.adminportal.entity.Student;

public interface StudentDAO {
    List<Student> findAll();
    Student findById(Long id);
    void save(Student student);
    void deleteById(Long id);
}
