package com.twinkieman.weblab.dao;

import com.twinkieman.weblab.models.Game;
import com.twinkieman.weblab.DatabaseErrors;

import java.util.List;

public interface GameDAO {

    Game findById(int id) throws DatabaseErrors.EntityManagerFactoryError;
    void edit(Game game) throws DatabaseErrors.EntityManagerFactoryError;
    void delete(Game game) throws DatabaseErrors.EntityManagerFactoryError;
    void add(Game game) throws DatabaseErrors.EntityManagerFactoryError;
    List<Game> getAllGames() throws DatabaseErrors.EntityManagerFactoryError;
    List<Game> searchByName(String gameName) throws DatabaseErrors.EntityManagerFactoryError;
    List<Game> searchByCompany(int companyId) throws DatabaseErrors.EntityManagerFactoryError;

}
