package com.example.service.impl;

import com.example.model.League;
import com.example.model.Player;
import com.example.model.Score;
import com.example.model.Team;
import com.example.service.TeamService;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class TeamServiceImpl implements TeamService {

    @PersistenceContext(name = "soa-2017")
    EntityManager entityManager;

    @Override
    public League findLeagueByName(String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<League> cq = cb.createQuery(League.class);
        Root<League> from = cq.from(League.class);
        cq.where(cb.equal(from.get("name"), name));
        System.out.println(entityManager.createQuery(cq).getSingleResult());
        return entityManager.createQuery(cq).getSingleResult();
    }

    @Override
    public Team findTeamByName(String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Team> cq = cb.createQuery(Team.class);
        Root<Team> from = cq.from(Team.class);
        cq.where(cb.equal(from.get("name"), name));
        return entityManager.createQuery(cq).getSingleResult();
    }

    @Override
    public void addTeam(String name, League league) {
        Team team = new Team(name, league);
        entityManager.persist(team);
    }

    @Override
    public void addPlayerToTeam(String name, Team team) {
        Player player = new Player(name, team);
        entityManager.persist(player);
    }

    public List<Score> getScoresByLeague(String leagueName) {
        return null;
    }

    public List<Score> getScoresBySport(String sportName) {
        return null;
    }
}
