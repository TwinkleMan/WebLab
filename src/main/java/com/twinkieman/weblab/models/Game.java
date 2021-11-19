package com.twinkieman.weblab.models;

import javax.persistence.*;

@Entity
@Table(name = "games")
public class Game {

    private int id;
    private String name;
    private Company company;

    @Id
    @Column(name = "game_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "game_name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.MERGE)
    @JoinColumn(name = "company_id", nullable = false)
    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company){
        this.company = company;
    }
}