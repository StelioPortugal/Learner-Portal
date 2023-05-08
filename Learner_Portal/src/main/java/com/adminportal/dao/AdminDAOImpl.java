package com.adminportal.dao;

import com.adminportal.entity.Admin;

import javax.persistence.EntityManager;
import java.util.List;

public class AdminDAOImpl implements AdminDAO {

    private EntityManager entityManager;

    public AdminDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Admin findAdminByUsername(String username) {
        try {
            return entityManager.createQuery("SELECT a FROM Admin a WHERE a.username = :username", Admin.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Admin saveAdmin(Admin admin) { // Updated method name
        try {
            entityManager.getTransaction().begin();

            if (admin.getId() == null) {
                // If the admin does not have an ID, persist a new record
                entityManager.persist(admin);
            } else {
                // If the admin has an ID, update the existing record
                admin = entityManager.merge(admin);
            }

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
        return admin;
    }

    @Override
    public boolean existsAdminByUsername(String username) {
        try {
            entityManager.createQuery("SELECT 1 FROM Admin a WHERE a.username = :username")
                    .setParameter("username", username)
                    .getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
