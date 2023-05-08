package com.adminportal.services;

import com.adminportal.dao.TeacherDAO;
import com.adminportal.dao.TeacherDAOImpl;
import com.adminportal.entity.Teacher;
import com.adminportal.services.TeacherService;
import java.util.List;

public class TeacherServiceImpl implements TeacherService {

    private TeacherDAO teacherDao = new TeacherDAOImpl();

    @Override
    public List<Teacher> findAll() {
        return teacherDao.findAll();
    }

    @Override
    public Teacher findById(Long id) {
        return teacherDao.findById(id);
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherDao.save(teacher);
    }

    @Override
    public void deleteById(Long id) {
        teacherDao.deleteById(id);
    }
}