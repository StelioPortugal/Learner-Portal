package com.adminportal.services;



import java.util.List;

import com.adminportal.entity.Teacher;

public interface TeacherService {
    List<Teacher> findAll();
    Teacher findById(Long id);
    Teacher save(Teacher teacher);
    void deleteById(Long id);
}
