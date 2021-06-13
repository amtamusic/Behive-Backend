package com.andytech.behive.repositories;

import com.andytech.behive.entities.common.Skill;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepo extends MongoRepository<Skill, String> {
}
