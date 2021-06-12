package com.andytech.behive.controllers;

import com.andytech.behive.entities.team.Team;
import com.andytech.behive.services.TeamService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class TeamControllerTest {
    @InjectMocks
    @Autowired
    TeamController teamController = new TeamController();

    @Mock
    TeamService teamService;

    @Test
    void addTeamTest() throws Exception {
        Team team = new Team();
        when(teamService.addTeam(any())).thenReturn(team);
        ResponseEntity<Team> responseEntity = teamController.addTeam(team);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void deleteTeamTest() throws Exception {
        Team team = new Team();
        when(teamService.deleteTeam(any())).thenReturn(true);
        ResponseEntity<String> responseEntity = teamController.deleteTeam(team);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void updateTeamTest() throws Exception {
        Team team = new Team();
        when(teamService.updateTeam(any())).thenReturn(team);
        ResponseEntity<Team> responseEntity = teamController.updateTeam(team);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void getTeamTest() throws Exception {
        Team team = new Team();
        when(teamService.getTeam(any())).thenReturn(team);
        ResponseEntity<Team> responseEntity = teamController.getTeam("1");
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void getTeamTestFail() throws Exception {
        Team team = new Team();
        when(teamService.getTeam(any())).thenReturn(team);
        ResponseEntity<Team> responseEntity = teamController.getTeam("a");
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }
}