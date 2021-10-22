package com.twinkieman.weblab.models;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    private int id;
    private String name;
    private String password;
    private Set<Game> ownedGames;
    private Map <Game, Integer> gamesProgress;

    public User() {
        ownedGames = new HashSet<>();
        gamesProgress = new HashMap<>();
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
            joinColumns = @JoinColumn(name = "user_id"),
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
    @JoinTable(name = "user_owned_games",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = {
                    @JoinColumn(name = "completed"),
                    @JoinColumn(name = "game_id")
            }
    )
    public Map<Game, Integer> getGamesProgress() {
        return gamesProgress;
    }
    public void setGamesProgress(Map<Game, Integer> gamesProgress) {
        this.gamesProgress = gamesProgress;
    }
    public void AddGameProgress(Game game, Integer gameProgress) {
        gamesProgress.put(game, gameProgress);
    }
}
