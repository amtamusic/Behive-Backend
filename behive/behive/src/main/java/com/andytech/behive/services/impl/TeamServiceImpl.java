package com.andytech.behive.services.impl;

import com.andytech.behive.entities.team.Team;
import com.andytech.behive.repositories.TeamRepo;
import com.andytech.behive.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepo teamRepo;

    @Override
    public Team getTeam(String id) {
        Optional<Team> team = teamRepo.findById(id);
        if (team.isPresent()) {
            return team.get();
        }
        return null;
    }

    @Override
    public Team addTeam(Team team) {
        return teamRepo.save(team);
    }

    @Override
    public Team updateTeam(Team team) {
        return teamRepo.save(team);
    }

    @Override
    public boolean deleteTeam(Team team) {
        teamRepo.delete(team);
        return true;
    }
}
