package com.adminportal.dao;


import com.adminportal.dao.SubjectDAO;
import com.adminportal.entity.Subject;
import com.adminportal.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class SubjectDAOImpl implements SubjectDAO {

    @Override
    public List<Subject> findAll() {

	EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
	TypedQuery<Subject> query = entityManager.createQuery("SELECT s FROM Subject s", Subject.class);
	List<Subject> subjects = query.getResultList();
	entityManager.close();
	return subjects;
	}   
    
    @Override
    public Subject findById(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        Subject subject = entityManager.find(Subject.class, id);
        entityManager.close();
        return subject;
    }

    @Override
    public Subject save(Subject subject) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Subject savedSubject = entityManager.merge(subject);
        entityManager.getTransaction().commit();
        entityManager.close();
        return savedSubject;
    }

    @Override
    public void deleteById(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Subject subject = entityManager.find(Subject.class, id);
        if (subject != null) {
            entityManager.remove(subject);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}