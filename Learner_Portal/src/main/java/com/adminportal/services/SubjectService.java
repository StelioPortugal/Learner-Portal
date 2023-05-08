package com.adminportal.services;

import java.util.List;

import com.adminportal.entity.Subject;

public interface SubjectService {
    List<Subject> findAll();
    Subject findById(Long id);
    Subject save(Subject subject);
    void deleteById(Long id);
}
