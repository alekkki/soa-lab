package com.example.web;

import com.example.model.Sport;
import com.example.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class SportController {

    private SportService sportService;

    @Autowired
    public SportController(SportService sportService) {
        this.sportService = sportService;
    }

    @RequestMapping(value = "/addSport", method = RequestMethod.POST)
    public Sport addSport(@RequestParam(value = "sportName") String name) {
        return sportService.addSport(name);
    }
}
