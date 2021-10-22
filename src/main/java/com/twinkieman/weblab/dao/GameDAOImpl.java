package com.twinkieman.weblab.dao;

import com.twinkieman.weblab.DatabaseErrors;
import com.twinkieman.weblab.models.Game;
import com.twinkieman.weblab.models.Company;
import com.twinkieman.weblab.utils.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class GameDAOImpl implements GameDAO{
    @Override
    public Game findById(int id) throws DatabaseErrors.EntityManagerFactoryError {
        return EntityManagerUtil.getEntityManager().find(Game.class, id);
    }

    @Override
    public void edit(Game game) throws DatabaseErrors.EntityManagerFactoryError {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(game);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Game game) throws DatabaseErrors.EntityManagerFactoryError {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(game);
        em.getTransaction().commit();
    }

    @Override
    public void add(Game game) throws DatabaseErrors.EntityManagerFactoryError {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(game);
        em.getTransaction().commit();
    }

    @Override
    public List<Game> getAllGames() throws DatabaseErrors.EntityManagerFactoryError {
        List<Game> result;

        result = EntityManagerUtil.getEntityManager().createQuery("from Game ").getResultList();

        return result;
    }

    @Override
    public List<Game> searchByName(String gameName) throws DatabaseErrors.EntityManagerFactoryError {
        List<Game> result;

        Query query = EntityManagerUtil.getEntityManager().createQuery("FROM Game g where g.name = :searchName");
        query.setParameter("searchName", gameName);
        result = query.getResultList();

        return result;
    }

    @Override
    public List<Game> searchByCompany(int companyId) throws DatabaseErrors.EntityManagerFactoryError {
        List<Game> result;

        Query query = EntityManagerUtil.getEntityManager().createQuery("FROM Game g where g.company.id = :searchId");
        query.setParameter("searchId", companyId);
        result = query.getResultList();

        return result;
    }
}
