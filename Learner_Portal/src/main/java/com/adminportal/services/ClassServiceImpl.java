package com.adminportal.services;

import com.adminportal.dao.ClassDAO;
import com.adminportal.dao.ClassDAOImpl;
import com.adminportal.entity.Class;
import com.adminportal.services.ClassService;
import java.util.List;

public class ClassServiceImpl implements ClassService {

    private ClassDAO classDao = new ClassDAOImpl();

    @Override
    public List<Class> findAll() {
        return classDao.findAll();
    }

    @Override
    public Class findById(Long id) {
        return classDao.findById(id);
    }

    @Override
    public Class save(Class clazz) {
        return classDao.save(clazz);
    }

    @Override
    public void deleteById(Long id) {
        classDao.deleteById(id);
    }
}
