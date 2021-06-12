package com.andytech.behive.controllers;

import com.andytech.behive.entities.team.Team;
import com.andytech.behive.services.TeamService;
import com.andytech.behive.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    TeamService teamService;

    LogUtils logUtils;

    public TeamController() {
        this.logUtils = new LogUtils();
        this.logUtils.setLoggerClass(this.getClass());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Team> getTeam(@PathVariable("id") String id) {
        logUtils.logString(String.format("Passed in id: %s", id));
        var team = teamService.getTeam(id);
        logUtils.logObject("Retrieved team by id", team);
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<Team> addTeam(@RequestBody Team team) {
        logUtils.logObject("Add Team received: %s", team);
        team = teamService.addTeam(team);
        logUtils.logObject("Add Team result: %s", team);
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<Team> updateTeam(@RequestBody Team team) {
        logUtils.logObject("Update Team received: %s", team);
        team = teamService.updateTeam(team);
        logUtils.logObject("Update Team result: %s", team);
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public ResponseEntity<String> deleteTeam(@RequestBody Team team) {
        logUtils.logObject("Delete Team received: %s", team);
        teamService.deleteTeam(team);
        logUtils.logObject("Delete Team result: %s", team);
        return new ResponseEntity<>(logUtils.getLogMessage().getMessage(), HttpStatus.OK);
    }
}
