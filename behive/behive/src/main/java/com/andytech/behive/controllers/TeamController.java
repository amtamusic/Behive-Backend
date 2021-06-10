package com.andytech.behive.controllers;

import com.andytech.behive.entities.team.Team;
import com.andytech.behive.utils.LogMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class TeamController {
    Logger log = LoggerFactory.getLogger(TeamController.class);
    LogMessage message = new LogMessage("");

    @GetMapping("/get/{id}")
    public ResponseEntity<Team> getTeam(@PathVariable("id") String id) {

        message.setMessage(String.format("Passed in id: %s", id));
        log.info(message.getMessage());
        var team = new Team();
        try {
            team.setId(Long.parseLong(id));
        } catch (Exception e) {
            team.setId(-1L);
        }
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<Team> addTeam(@RequestBody Team team) {
        message.setMessage(String.format("Add Team received: %s", team.toString()));
        log.info(message.getMessage());
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<Team> updateTeam(@RequestBody Team team) {
        message.setMessage(String.format("update Team received: %s", team.toString()));
        log.info(message.getMessage());
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public ResponseEntity<Team> deleteTeam(@RequestBody Team team) {
        message.setMessage(String.format("Delete Team received: %s", team.toString()));
        log.info(message.getMessage());
        return new ResponseEntity<>(team, HttpStatus.OK);
    }
}
