package com.andytech.behive.services.impl;

import com.andytech.behive.entities.team.Team;
import com.andytech.behive.repositories.TeamRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class TeamServiceImplTest {

    @Autowired
    @InjectMocks
    TeamServiceImpl teamService = new TeamServiceImpl();

    @Mock
    TeamRepo teamRepo;

    @Test
    void addTeamTest() {
        Team team = new Team();
        when(teamRepo.save(any())).thenReturn(team);
        Team response = teamService.addTeam(team);
        assertThat(response).isNotNull();
    }

    @Test
    void deleteTeamTest() throws Exception {
        Team team = new Team();
        assertThat(teamService.deleteTeam(team)).isTrue();
    }

    @Test
    void updateTeamTest() throws Exception {
        Team team = new Team();
        when(teamRepo.save(any())).thenReturn(team);
        Team responseEntity = teamService.updateTeam(team);
        assertThat(responseEntity).isNotNull();
    }

    @Test
    void getTeamTest() throws Exception {
        Team team = new Team();
        when(teamRepo.findById(any())).thenReturn(Optional.of(team));
        Team responseEntity = teamService.getTeam("1");
        assertThat(responseEntity).isNotNull();
    }

    @Test
    void getTeamTestNotPresent() throws Exception {
        when(teamRepo.findById(any())).thenReturn(Optional.empty());
        Team responseEntity = teamService.getTeam("1");
        assertThat(responseEntity).isNull();
    }
}