package com.example.service.impl;

import com.example.model.Sport;
import com.example.persistence.SportRepository;
import com.example.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportServiceImpl implements SportService {

    private final SportRepository sportRepository;

    @Autowired
    public SportServiceImpl(SportRepository sportRepository) {
        this.sportRepository = sportRepository;
    }

    @Override
    public Sport addSport(String name) {
        Sport sport = new Sport(name);
        return sportRepository. save(sport);
    }
}
