package com.adminportal.dao;

import java.util.List;

import com.adminportal.entity.Subject;

public interface SubjectDAO {
    List<Subject> findAll();
    Subject findById(Long id);
    Subject save(Subject subject);
    void deleteById(Long id);
}
