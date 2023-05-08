package com.adminportal.dao;

import java.util.List;

import com.adminportal.entity.Teacher;

public interface TeacherDAO {
    List<Teacher> findAll();
    Teacher findById(Long id);
    Teacher save(Teacher teacher);
    void deleteById(Long id);
}
