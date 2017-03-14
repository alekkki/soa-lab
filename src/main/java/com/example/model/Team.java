package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(referencedColumnName = "league_id")
    private League league;

    public Team() {}

    public Team(String name, League league) {
        this.name = name;
        this.league = league;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public League getLeague() {
        return league;
    }
}
