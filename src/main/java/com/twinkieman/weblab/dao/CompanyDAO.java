package com.twinkieman.weblab.dao;

import com.twinkieman.weblab.models.Company;
import com.twinkieman.weblab.DatabaseErrors;
import com.twinkieman.weblab.models.Game;

import java.util.List;

public interface CompanyDAO {


    Company findById(int id) throws DatabaseErrors.EntityManagerFactoryError;
    void edit(Company company) throws DatabaseErrors.EntityManagerFactoryError;
    void delete(Company company) throws DatabaseErrors.EntityManagerFactoryError;
    void add(Company company) throws DatabaseErrors.EntityManagerFactoryError;
    List<Company> getAllCompanies() throws DatabaseErrors.EntityManagerFactoryError;
    List<Company> searchByName(String companyName) throws DatabaseErrors.EntityManagerFactoryError;
    List<Game> getAllCompanyGames(Company company) throws DatabaseErrors.EntityManagerFactoryError;

}
