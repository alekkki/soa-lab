package com.example.service.impl;

import com.example.model.League;
import com.example.model.Team;
import com.example.persistence.LeagueRepository;
import com.example.persistence.TeamRepository;
import com.example.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final LeagueRepository leagueRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, LeagueRepository leagueRepository) {
        this.teamRepository = teamRepository;
        this.leagueRepository = leagueRepository;
    }

    @Override
    public Team addTeam(String name, Long leagueId) {
        League league = leagueRepository.findOne(leagueId);
        Team team = new Team(name, league);
        return teamRepository.save(team);
    }

    @Override
    public Team findTeamByName(String name) {
        return teamRepository.findTeamByName(name);
    }
}
