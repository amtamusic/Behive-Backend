package com.andytech.behive.services.impl;

import com.andytech.behive.entities.common.Skill;
import com.andytech.behive.repositories.SkillRepo;
import com.andytech.behive.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepo teamRepo;

    @Override
    public Skill getSkill(String id) {
        Optional<Skill> team = teamRepo.findById(id);
        if (team.isPresent()) {
            return team.get();
        }
        return null;
    }

    @Override
    public Skill addSkill(Skill skill) {
        return teamRepo.save(skill);
    }

    @Override
    public Skill updateSkill(Skill skill) {
        return teamRepo.save(skill);
    }

    @Override
    public boolean deleteSkill(Skill skill) {
        teamRepo.delete(skill);
        return true;
    }
}
