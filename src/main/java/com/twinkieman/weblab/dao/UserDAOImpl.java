package com.twinkieman.weblab.dao;

import com.twinkieman.weblab.DatabaseErrors;
import com.twinkieman.weblab.models.Game;
import com.twinkieman.weblab.models.User;
import com.twinkieman.weblab.utils.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;

public class UserDAOImpl implements UserDAO{
    @Override
    public User findById(int id) throws DatabaseErrors.EntityManagerFactoryError {
        return EntityManagerUtil.getEntityManager().find(User.class, id);
    }

    @Override
    public void edit(User user) throws DatabaseErrors.EntityManagerFactoryError {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    @Override
    public void delete(User user) throws DatabaseErrors.EntityManagerFactoryError {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
    }

    @Override
    public void add(User user) throws DatabaseErrors.EntityManagerFactoryError {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public List<User> getAllUsers() throws DatabaseErrors.EntityManagerFactoryError {
        List<User> result;

        result = EntityManagerUtil.getEntityManager().createQuery("FROM User ").getResultList();

        return result;
    }

    @Override
    public List<User> searchByName(String name) throws DatabaseErrors.EntityManagerFactoryError {
        List<User> result;

        Query query = EntityManagerUtil.getEntityManager().createQuery("FROM User U where U.name = :searchName");
        query.setParameter("searchName", name);
        result = query.getResultList();

        return result;
    }

    @Override
    public List<User> searchByLogin(String login) throws DatabaseErrors.EntityManagerFactoryError {
        List<User> result;

        Query query = EntityManagerUtil.getEntityManager().createQuery("FROM User U where U.login = :searchLogin");
        query.setParameter("searchLogin", login);
        result = query.getResultList();

        return result;
    }

    @Override
    public List<Game> getOwnedGames(User user) throws DatabaseErrors.EntityManagerFactoryError {
        List<Game> result;

        Query query = EntityManagerUtil.getEntityManager().createQuery("select Game from User ");
        result = query.getResultList();

        return result;
    }

    @Override
    public List<Integer> getGameProgress(User user) throws DatabaseErrors.EntityManagerFactoryError {
        List<Integer> result = new ArrayList<>();
        List<User> users;

        Query query = EntityManagerUtil.getEntityManager().createQuery("from User u WHERE u.id = :searchId");
        query.setParameter("searchId", user.getId());
        users = query.getResultList();

        if (users != null) {
            for (Integer val: users.get(0).getGamesProgress()) {
                result.add(val);
            }
        }

        return result;
    }
}