package com.andytech.behive.services;

import com.andytech.behive.entities.common.Skill;

public interface SkillService {

    Skill getSkill(String id);

    Skill addSkill(Skill skill);

    Skill updateSkill(Skill skill);

    boolean deleteSkill(Skill skill);
}
