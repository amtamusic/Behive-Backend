package com.andytech.behive.controllers;

import com.andytech.behive.entities.common.Skill;
import com.andytech.behive.services.SkillService;
import com.andytech.behive.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/skill")
public class SkillController {
    @Autowired
    SkillService skillService;

    LogUtils logUtils;

    public SkillController() {
        this.logUtils = new LogUtils();
        this.logUtils.setLoggerClass(this.getClass());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Skill> getSkill(@PathVariable("id") String id) {
        logUtils.logString(String.format("Update Skill received: %s", id));
        var skill = skillService.getSkill(id);
        logUtils.logObject("Returned skill after lookup by id : %s", skill);
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<Skill> addSkill(@RequestBody Skill skill) {
        logUtils.logObject("Add Skill received: %s", skill);
        skill = skillService.addSkill(skill);
        logUtils.logObject("Add Skill result: %s", skill);
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<Skill> updateSkill(@RequestBody Skill skill) {
        logUtils.logObject("Update Skill received: %s", skill);
        skill = skillService.updateSkill(skill);
        logUtils.logObject("Update Skill result: %s", skill);
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public ResponseEntity<Skill> deleteSkill(@RequestBody Skill skill) {
        logUtils.logObject("Delete Skill received: %s", skill);
        skillService.deleteSkill(skill);
        logUtils.logString("Skill " + skill.toString() + " deleted");
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }
}
