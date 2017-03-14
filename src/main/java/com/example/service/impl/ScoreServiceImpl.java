package com.example.service.impl;

import com.example.model.League;
import com.example.model.Score;
import com.example.model.Team;
import com.example.persistence.LeagueRepository;
import com.example.persistence.ScoreRepository;
import com.example.persistence.TeamRepository;
import com.example.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl implements ScoreService {

    private final ScoreRepository scoreRepository;
    private final TeamRepository teamRepository;
    private final LeagueRepository leagueRepository;

    @Autowired
    public ScoreServiceImpl(ScoreRepository scoreRepository, TeamRepository teamRepository, LeagueRepository leagueRepository) {
        this.scoreRepository = scoreRepository;
        this.teamRepository = teamRepository;
        this.leagueRepository = leagueRepository;
    }

    @Override
    public Score addScore(Long hostTeamId, Long guestTeamId, Long leagueId, Integer hostScore, Integer guestScore) {

        Team hostTeam = teamRepository.findOne(hostTeamId);
        Team guestTeam = teamRepository.findOne(guestTeamId);
        League league = leagueRepository.findOne(leagueId);

        Score score = new Score(hostTeam, guestTeam, league, hostScore, guestScore);
        return scoreRepository.save(score);
    }
}
