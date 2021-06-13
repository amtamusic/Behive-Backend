package com.andytech.behive.controllers;

import com.andytech.behive.entities.team.Project;
import com.andytech.behive.services.ProjectService;
import com.andytech.behive.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    LogUtils logUtils;

    public ProjectController() {
        this.logUtils = new LogUtils();
        this.logUtils.setLoggerClass(this.getClass());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Project> getProject(@PathVariable("id") String id) {
        logUtils.logString(String.format("Passed in id: %s", id));
        var project = projectService.getProject(id);
        logUtils.logObject("Retrieved project by id", project);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<Project> addProject(@RequestBody Project project) {
        logUtils.logObject("Add Project received: %s", project);
        project = projectService.addProject(project);
        logUtils.logObject("Add Project result: %s", project);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<Project> updateProject(@RequestBody Project project) {
        logUtils.logObject("Update Project received: %s", project);
        project = projectService.updateProject(project);
        logUtils.logObject("Update Project result: %s", project);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public ResponseEntity<Project> deleteProject(@RequestBody Project project) {
        logUtils.logObject("Delete Project received: %s", project);
        projectService.deleteProject(project);
        logUtils.logObject("Delete Project result: %s", project);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }
}
