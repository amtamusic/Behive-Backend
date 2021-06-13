package com.andytech.behive.services;

import com.andytech.behive.entities.team.Project;

public interface ProjectService {

    Project getProject(String id);

    Project addProject(Project project);

    Project updateProject(Project project);

    boolean deleteProject(Project project);
}
