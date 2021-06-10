package com.andytech.behive.controllers;

import com.andytech.behive.entities.team.Team;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class TeamControllerTest {
    @InjectMocks
    TeamController teamController;

    @Test
    void addTeamTest() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        Team team = new Team();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        ResponseEntity<Team> responseEntity = teamController.addTeam(team);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void deleteTeamTest() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        Team team = new Team();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        ResponseEntity<Team> responseEntity = teamController.deleteTeam(team);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void updateTeamTest() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        Team team = new Team();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        ResponseEntity<Team> responseEntity = teamController.updateTeam(team);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void getTeamTest() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        ResponseEntity<Team> responseEntity = teamController.getTeam("1");
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void getTeamTestFail() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        ResponseEntity<Team> responseEntity = teamController.getTeam("a");
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }
}