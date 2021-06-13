package com.andytech.behive.controllers;

import com.andytech.behive.entities.team.Project;
import com.andytech.behive.services.ProjectService;
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
class ProjectControllerTest {
    @InjectMocks
    @Autowired
    ProjectController projectController = new ProjectController();

    @Mock
    ProjectService projectService;

    @Test
    void addProjectTest() {
        Project project = new Project();
        when(projectService.addProject(any())).thenReturn(project);
        ResponseEntity<Project> responseEntity = projectController.addProject(project);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void deleteProjectTest() {
        Project project = new Project();
        when(projectService.deleteProject(any())).thenReturn(true);
        ResponseEntity<Project> responseEntity = projectController.deleteProject(project);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void updateProjectTest() {
        Project project = new Project();
        when(projectService.updateProject(any())).thenReturn(project);
        ResponseEntity<Project> responseEntity = projectController.updateProject(project);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void getProjectTest() {
        Project project = new Project();
        when(projectService.getProject(any())).thenReturn(project);
        ResponseEntity<Project> responseEntity = projectController.getProject("1");
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void getProjectTestFail() {
        Project project = new Project();
        when(projectService.getProject(any())).thenReturn(project);
        ResponseEntity<Project> responseEntity = projectController.getProject("a");
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }
}