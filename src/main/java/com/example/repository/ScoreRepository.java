package com.example.repository;

import com.example.model.League;
import com.example.model.Player;
import com.example.model.Score;
import com.example.model.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ScoreRepository  {

    void addTeam(String name, League league);

    void addPlayerToTeam(String name, Team team);

    League findLeagueByName(String name);

    Team findTeamByName(String name);

    List<Score> getScoresByLeague(String leagueName);

    List<Score> getScoresBySport(String sportName);
}
