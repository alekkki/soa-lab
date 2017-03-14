package com.example.web;

import com.example.model.Team;
import com.example.service.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class TeamController {

    private TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @RequestMapping(value = "/addTeam", method = RequestMethod.POST)
    public Team addTeam(@RequestParam(value = "teamName") String name, @RequestParam(value = "leagueId") Long leagueId) {
        return teamService.addTeam(name, leagueId);
    }

    @RequestMapping(value = "/findTeamByName", method = RequestMethod.GET)
    public Team findTeamByName(@RequestParam(value = "teamName") String name) {
        return teamService.findTeamByName(name);
    }
}
