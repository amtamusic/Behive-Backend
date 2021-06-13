package com.andytech.behive.services.impl;

import com.andytech.behive.entities.common.Skill;
import com.andytech.behive.repositories.SkillRepo;
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
class SkillServiceImplTest {

    @Autowired
    @InjectMocks
    SkillServiceImpl SkillService = new SkillServiceImpl();

    @Mock
    SkillRepo SkillRepo;

    @Test
    void addSkillTest() {
        Skill skill = new Skill();
        when(SkillRepo.save(any())).thenReturn(skill);
        Skill response = SkillService.addSkill(skill);
        assertThat(response).isNotNull();
    }

    @Test
    void deleteSkillTest() throws Exception {
        Skill skill = new Skill();
        assertThat(SkillService.deleteSkill(skill)).isTrue();
    }

    @Test
    void updateSkillTest() throws Exception {
        Skill skill = new Skill();
        when(SkillRepo.save(any())).thenReturn(skill);
        Skill responseEntity = SkillService.updateSkill(skill);
        assertThat(responseEntity).isNotNull();
    }

    @Test
    void getSkillTest() throws Exception {
        Skill skill = new Skill();
        when(SkillRepo.findById(any())).thenReturn(Optional.of(skill));
        Skill responseEntity = SkillService.getSkill("1");
        assertThat(responseEntity).isNotNull();
    }

    @Test
    void getSkillTestNotPresent() throws Exception {
        when(SkillRepo.findById(any())).thenReturn(Optional.empty());
        Skill responseEntity = SkillService.getSkill("1");
        assertThat(responseEntity).isNull();
    }
}