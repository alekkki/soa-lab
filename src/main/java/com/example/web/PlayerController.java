package com.example.web;

import com.example.model.Player;
import com.example.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping(value = "/addPlayer", method = RequestMethod.POST)
    public Player addPlayer(@RequestParam(value = "name") String name, @RequestParam(value = "teamId") Long teamId) {
        return playerService.addPlayer(name, teamId);
    }
}
