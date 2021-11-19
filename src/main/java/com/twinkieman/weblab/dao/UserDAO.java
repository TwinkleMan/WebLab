package com.twinkieman.weblab.dao;

import com.twinkieman.weblab.DatabaseErrors;
import com.twinkieman.weblab.models.Game;
import com.twinkieman.weblab.models.User;

import java.util.HashMap;
import java.util.List;

public interface UserDAO {

    User findById(int id) throws DatabaseErrors.EntityManagerFactoryError;
    void edit(User user) throws DatabaseErrors.EntityManagerFactoryError;
    void delete(User user) throws DatabaseErrors.EntityManagerFactoryError;
    void add(User user) throws DatabaseErrors.EntityManagerFactoryError;
    List<User> getAllUsers() throws DatabaseErrors.EntityManagerFactoryError;
    List<User> searchByName(String name) throws DatabaseErrors.EntityManagerFactoryError;
    List<User> searchByLogin(String login) throws DatabaseErrors.EntityManagerFactoryError;
    List<Game> getOwnedGames(User user) throws DatabaseErrors.EntityManagerFactoryError;
    List<Integer> getGameProgress(User user) throws DatabaseErrors.EntityManagerFactoryError;

}