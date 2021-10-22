package com.twinkieman.weblab.dao;

import com.twinkieman.weblab.DatabaseErrors;
import com.twinkieman.weblab.models.Company;
import com.twinkieman.weblab.models.Game;
import com.twinkieman.weblab.utils.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CompanyDAOImpl implements CompanyDAO{
    @Override
    public Company findById(int id) throws DatabaseErrors.EntityManagerFactoryError {
        return EntityManagerUtil.getEntityManager().find(Company.class, id);
    }

    @Override
    public void edit(Company company) throws DatabaseErrors.EntityManagerFactoryError {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(company);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Company company) throws DatabaseErrors.EntityManagerFactoryError {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(company);
        em.getTransaction().commit();
    }

    @Override
    public void add(Company company) throws DatabaseErrors.EntityManagerFactoryError {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(company);
        em.getTransaction().commit();
    }

    @Override
    public List<Company> getAllCompanies() throws DatabaseErrors.EntityManagerFactoryError {
        List<Company> result;
        result = EntityManagerUtil.getEntityManager().createQuery("from Company ").getResultList();

        return result;
    }

    @Override
    public List<Company> searchByName(String companyName) throws DatabaseErrors.EntityManagerFactoryError {
        List<Company> result;
        Query query = EntityManagerUtil.getEntityManager().createQuery("from Company C where C.name = :searchName");
        query.setParameter("searchName", companyName);

        result = query.getResultList();

        return result;
    }

    @Override
    public List<Game> getAllCompanyGames(Company company) throws DatabaseErrors.EntityManagerFactoryError {
        List<Game> result;
        Query query = EntityManagerUtil.getEntityManager().createQuery("from Company, " +
                "IN (Company.games) games where games.company.id = :currentCompany");
        query.setParameter("currentCompany",company.getId());

        result = query.getResultList();

        return result;
    }
}
