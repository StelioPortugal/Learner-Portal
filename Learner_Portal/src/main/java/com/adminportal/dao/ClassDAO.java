package com.adminportal.dao;

import java.util.List;

import com.adminportal.entity.Class;

public interface ClassDAO {
    List<Class> findAll();
    Class findById(Long id);
    Class save(Class clazz);
    void deleteById(Long id);
}
