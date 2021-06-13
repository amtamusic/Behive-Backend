package com.andytech.behive.controllers;

import com.andytech.behive.entities.common.Skill;
import com.andytech.behive.services.SkillService;
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
class SkillControllerTest {
    @InjectMocks
    @Autowired
    SkillController skillController = new SkillController();

    @Mock
    SkillService skillService;

    @Test
    void addSkillTest() {
        Skill skill = new Skill();
        when(skillService.addSkill(any())).thenReturn(skill);
        ResponseEntity<Skill> responseEntity = skillController.addSkill(skill);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void deleteSkillTest() {
        Skill skill = new Skill();
        when(skillService.deleteSkill(any())).thenReturn(true);
        ResponseEntity<Skill> responseEntity = skillController.deleteSkill(skill);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void updateSkillTest() {
        Skill skill = new Skill();
        when(skillService.updateSkill(any())).thenReturn(skill);
        ResponseEntity<Skill> responseEntity = skillController.updateSkill(skill);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void getSkillTest() {
        Skill skill = new Skill();
        when(skillService.getSkill(any())).thenReturn(skill);
        ResponseEntity<Skill> responseEntity = skillController.getSkill("1");
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void getSkillTestFail() {
        Skill skill = new Skill();
        when(skillService.getSkill(any())).thenReturn(skill);
        ResponseEntity<Skill> responseEntity = skillController.getSkill("a");
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }
}