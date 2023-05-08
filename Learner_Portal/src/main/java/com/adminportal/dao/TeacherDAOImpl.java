package com.adminportal.dao;



import com.adminportal.dao.TeacherDAO;
import com.adminportal.entity.Teacher;
import com.adminportal.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class TeacherDAOImpl implements TeacherDAO {

    @Override
    public List<Teacher> findAll() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Teacher> query = entityManager.createQuery("SELECT t FROM Teacher t", Teacher.class);
        List<Teacher> teachers = query.getResultList();
        entityManager.close();
        return teachers;
    }

    @Override
    public Teacher findById(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        Teacher teacher = entityManager.find(Teacher.class, id);
        entityManager.close();
        return teacher;
    }

    @Override
    public Teacher save(Teacher teacher) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Teacher savedTeacher = entityManager.merge(teacher);
        entityManager.getTransaction().commit();
        entityManager.close();
        return savedTeacher;
    }

    @Override
    public void deleteById(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Teacher teacher = entityManager.find(Teacher.class, id);
        if (teacher != null) {
            entityManager.remove(teacher);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
