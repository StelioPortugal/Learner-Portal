package com.adminportal.dao;

import com.adminportal.dao.StudentDAO;
import com.adminportal.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> findAll() {
        Query query = entityManager.createQuery("SELECT s FROM Student s");
        return query.getResultList();
    }

    @Override
    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public void deleteById(Long id) {
        Query query = entityManager.createQuery("DELETE FROM Student s WHERE s.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
