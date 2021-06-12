package com.andytech.behive.services;

import com.andytech.behive.entities.team.Team;

public interface TeamService {

    Team getTeam(String id);

    Team addTeam(Team team);

    Team updateTeam(Team team);

    boolean deleteTeam(Team team);
}
