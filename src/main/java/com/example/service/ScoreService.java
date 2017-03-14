package com.example.service;

import com.example.model.Score;

public interface ScoreService {

    Score addScore(Long hostTeamId, Long guestTeamId, Long leagueId, Integer hostScore, Integer guestScore);
}
