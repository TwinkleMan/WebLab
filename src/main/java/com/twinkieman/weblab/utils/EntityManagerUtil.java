package com.twinkieman.weblab.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.twinkieman.weblab.DatabaseErrors;

public class EntityManagerUtil {

    private static EntityManager entityManager;

    private EntityManagerUtil(){}

    public static EntityManager getEntityManager() throws DatabaseErrors.EntityManagerFactoryError {

        if (entityManager == null) {
            try {
                EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("web_persistence");
                entityManager = entityManagerFactory.createEntityManager();
            } catch (Exception e) {
                throw new DatabaseErrors.EntityManagerFactoryError("Entity manager factory error");
            }
        }

        return entityManager;

    }

}
