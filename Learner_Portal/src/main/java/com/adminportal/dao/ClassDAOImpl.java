package com.adminportal.dao;

import com.adminportal.dao.ClassDAO;
import com.adminportal.entity.Class;
import com.adminportal.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ClassDAOImpl implements ClassDAO {

    @Override
    public List<Class> findAll() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Class> query = entityManager.createQuery("SELECT c FROM Class c", Class.class);
        List<Class> classes = query.getResultList();
        entityManager.close();
        return classes;
    }

    @Override
    public Class findById(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        Class clazz = entityManager.find(Class.class, id);
        entityManager.close();
        return clazz;
    }

    @Override
    public Class save(Class clazz) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Class savedClass = entityManager.merge(clazz);
        entityManager.getTransaction().commit();
        entityManager.close();
        return savedClass;
    }

    @Override
    public void deleteById(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Class clazz = entityManager.find(Class.class, id);
        if (clazz != null) {
            entityManager.remove(clazz);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
