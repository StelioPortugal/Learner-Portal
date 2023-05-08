package com.adminportal.services;

import com.adminportal.dao.SubjectDAO;
import com.adminportal.dao.SubjectDAOImpl;
import com.adminportal.entity.Subject;
import com.adminportal.services.SubjectService;
import java.util.List;

public class SubjectServiceImpl implements SubjectService {

    private SubjectDAO subjectDao = new SubjectDAOImpl();

    @Override
    public List<Subject> findAll() {
        return subjectDao.findAll();
    }

    @Override
    public Subject findById(Long id) {
        return subjectDao.findById(id);
    }

    @Override
    public Subject save(Subject subject) {
        return subjectDao.save(subject);
    }

    @Override
    public void deleteById(Long id) {
        subjectDao.deleteById(id);
    }
}