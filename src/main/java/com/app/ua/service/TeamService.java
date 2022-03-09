package com.app.ua.service;

import com.app.ua.entity.TeamEntity;
import com.app.ua.exception.TeamAlreadyExistException;
import com.app.ua.exception.TeamNotFoundException;
import com.app.ua.model.Team;
import com.app.ua.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author Vladislav Domaniewski 04
 */

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepos;

    public TeamEntity setTeam(TeamEntity team) throws TeamAlreadyExistException {
        if (teamRepos.findByNameTeam(team.getNameTeam()) != null) {
            throw  new TeamAlreadyExistException("This team will be here entity!!!");
        }
        return teamRepos.save(team);
    }

    public Team getOne(Integer id) throws TeamNotFoundException {
        TeamEntity team = teamRepos.findById(id).get();
        if (team == null) {
            throw new TeamNotFoundException("Команда не найдена!");
        }
        return Team.toModel(team);
    }

    public List<Team> findAll() {
        return teamRepos.findAll()
                .stream()
                .map(Team::toModel)
                .collect(Collectors.toList());
    }

    public Integer delete(Integer id) {
        teamRepos.deleteById(id);
        return id;
    }
}
