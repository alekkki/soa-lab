package com.example.web;

import com.example.model.League;
import com.example.model.Score;
import com.example.model.Team;
import com.example.service.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Win 8 on 13.03.2017.
 */
@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class TeamController {

    private TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @RequestMapping(value = "/findLeagueByName", method = RequestMethod.GET)
    public League getLeagueByName(@RequestParam(value = "leagueName", defaultValue = "EFL") String name) {
        return teamService.findLeagueByName(name);
    }

    @RequestMapping(value = "/findTeamByName", method = RequestMethod.GET)
    public Team findTeamByName(@RequestParam(value = "teamName", defaultValue = "Arsenal") String name) {
        return teamService.findTeamByName(name);
    }

    @RequestMapping(value = "/addTeam", method = RequestMethod.POST)
    public void addTeam(@RequestParam(value = "teamName") String name, @RequestParam(value = "leagueName", defaultValue = "Premier League") String leagueName) {
        League league = teamService.findLeagueByName(leagueName);
        teamService.addTeam(name, league);
    }

    @RequestMapping(value = "/addPlayer", method = RequestMethod.POST)
    public void addPlayer(@RequestParam(value = "playerName") String name, @RequestParam(value = "teamName") String teamName) {
        Team team = teamService.findTeamByName(teamName);
        teamService.addPlayerToTeam(name, team);
    }

    @RequestMapping(value = "/getScoresByLeague", method = RequestMethod.GET)
    public List<Score> getScoresByLeague(@RequestParam(value = "leagueName", defaultValue = "Premier League") String leagueName) {
        return teamService.getScoresByLeague(leagueName);
    }

    @RequestMapping(value = "/getScoresBySport", method = RequestMethod.GET)
    public List<Score> getScoresBySport(@RequestParam(value = "sportName", defaultValue = "football") String sportName) {
        return teamService.getScoresBySport(sportName);
    }
}
