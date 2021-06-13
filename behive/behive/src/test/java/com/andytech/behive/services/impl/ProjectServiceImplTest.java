package com.andytech.behive.services.impl;

import com.andytech.behive.entities.team.Project;
import com.andytech.behive.repositories.ProjectRepo;
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
class ProjectServiceImplTest {

    @Autowired
    @InjectMocks
    ProjectServiceImpl projectService = new ProjectServiceImpl();

    @Mock
    ProjectRepo projectRepo;

    @Test
    void addProjectTest() {
        Project project = new Project();
        when(projectRepo.save(any())).thenReturn(project);
        Project response = projectService.addProject(project);
        assertThat(response).isNotNull();
    }

    @Test
    void deleteProjectTest() throws Exception {
        Project project = new Project();
        assertThat(projectService.deleteProject(project)).isTrue();
    }

    @Test
    void updateProjectTest() throws Exception {
        Project project = new Project();
        when(projectRepo.save(any())).thenReturn(project);
        Project responseEntity = projectService.updateProject(project);
        assertThat(responseEntity).isNotNull();
    }

    @Test
    void getProjectTest() throws Exception {
        Project project = new Project();
        when(projectRepo.findById(any())).thenReturn(Optional.of(project));
        Project responseEntity = projectService.getProject("1");
        assertThat(responseEntity).isNotNull();
    }

    @Test
    void getProjectTestNotPresent() throws Exception {
        when(projectRepo.findById(any())).thenReturn(Optional.empty());
        Project responseEntity = projectService.getProject("1");
        assertThat(responseEntity).isNull();
    }
}