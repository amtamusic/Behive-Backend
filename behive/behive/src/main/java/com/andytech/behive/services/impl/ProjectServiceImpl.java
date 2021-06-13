package com.andytech.behive.services.impl;

import com.andytech.behive.entities.team.Project;
import com.andytech.behive.repositories.ProjectRepo;
import com.andytech.behive.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    @Override
    public Project getProject(String id) {
        Optional<Project> project = projectRepo.findById(id);
        if (project.isPresent()) {
            return project.get();
        }
        return null;
    }

    @Override
    public Project addProject(Project project) {
        return projectRepo.save(project);
    }

    @Override
    public Project updateProject(Project project) {
        return projectRepo.save(project);
    }

    @Override
    public boolean deleteProject(Project project) {
        projectRepo.delete(project);
        return true;
    }
}
