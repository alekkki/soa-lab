package com.example.service;

import com.example.model.League;
import com.example.model.Score;
import com.example.model.Team;

import java.util.List;

public interface TeamService {

    Team addTeam(String name, Long leagueId);

    Team findTeamByName(String name);
}
