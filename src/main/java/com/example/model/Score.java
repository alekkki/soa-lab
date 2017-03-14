package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "scores")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(referencedColumnName = "team_id")
    private Team hostTeam;

    @OneToOne
    @JoinColumn(referencedColumnName = "team_id")
    private Team guestTeam;

    @ManyToOne
    @JoinColumn(referencedColumnName = "league_id")
    private League league;

    private Integer hostScore;

    private Integer guestScore;

    public Score() {}

    public Score(Team hostTeam, Team guestTeam, League league, Integer hostScore, Integer guestScore) {
        this.hostTeam = hostTeam;
        this.guestTeam = guestTeam;
        this.league = league;
        this.hostScore = hostScore;
        this.guestScore = guestScore;
    }

    public Long getId() {
        return id;
    }

    public Team getHostTeam() {
        return hostTeam;
    }

    public Team getGuestTeam() {
        return guestTeam;
    }

    public League getLeague() {
        return league;
    }

    public Integer getHostScore() {
        return hostScore;
    }

    public Integer getGuestScore() {
        return guestScore;
    }
}
