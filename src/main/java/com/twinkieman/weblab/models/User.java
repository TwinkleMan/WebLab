package com.twinkieman.weblab.models;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class User {

    private int id;
    private String name;
    private String password;
    private String login;
    private Set<Game> ownedGames;
    private List<Integer> gamesProgress;

    public User() {
        ownedGames = new HashSet<>();
        gamesProgress = new ArrayList<>();
    }

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "user_name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "user_password")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToMany
    @JoinTable(name = "user_owned_games",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id")
    )
    public Set<Game> getOwnedGames() {
        return ownedGames;
    }
    public void setOwnedGames(Set<Game> ownedGames) {
        this.ownedGames = ownedGames;
    }
    public void addOwnedGame(Game game) {
        ownedGames.add(game);
    }

    @ElementCollection
    @CollectionTable(name = "user_owned_games",
            joinColumns = @JoinColumn(name = "users_id", referencedColumnName = "user_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"users_id","game_id"})}
    )
    @Column(name = "completed")
    public List<Integer> getGamesProgress() {
        return gamesProgress;
    }
    public void setGamesProgress(List<Integer> gamesProgress) {
        this.gamesProgress = gamesProgress;
    }

    @Column(name = "user_login")
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
}
