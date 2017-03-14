package com.example.service.impl;

import com.example.model.Player;
import com.example.model.Team;
import com.example.persistence.PlayerRepository;
import com.example.persistence.TeamRepository;
import com.example.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public Player addPlayer(String name, Long teamId) {
        Team team = teamRepository.findOne(teamId);
        Player player = new Player(name, team);
        return playerRepository.save(player);
    }
}
