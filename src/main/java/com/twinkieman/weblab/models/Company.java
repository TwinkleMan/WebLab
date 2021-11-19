package com.twinkieman.weblab.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "companies")
public class Company {

    private int id;
    private String name;
    private Set<Game> games;

    public Company() {
        games = new HashSet<>();
    }

    @Id
    @Column(name = "company_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "company_name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "company")
    public Set<Game> getGames() {
        return games;
    }
    public void setGames(Set<Game> games) {
        this.games = games;
    }
    public void addGame(Game game) {
        games.add(game);
    }
}