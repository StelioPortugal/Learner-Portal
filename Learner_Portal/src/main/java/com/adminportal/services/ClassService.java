package com.adminportal.services;


import java.util.List;

import com.adminportal.entity.Class;

public interface ClassService {
    List<Class> findAll();
    Class findById(Long id);
    Class save(Class clazz);
    void deleteById(Long id);
}
