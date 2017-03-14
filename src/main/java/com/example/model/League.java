package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "leagues")
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "league_id")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(referencedColumnName = "sport_id")
    private Sport sport;

    public League() {}

    public League(String name, Sport sport) {
        this.name = name;
        this.sport = sport;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Sport getSport() {
        return sport;
    }
}
