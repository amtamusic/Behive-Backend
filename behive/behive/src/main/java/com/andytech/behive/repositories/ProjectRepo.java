package com.andytech.behive.repositories;

import com.andytech.behive.entities.team.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends MongoRepository<Project, String> {
}
