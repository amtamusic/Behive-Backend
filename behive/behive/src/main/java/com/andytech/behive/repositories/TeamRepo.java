package com.andytech.behive.repositories;

import com.andytech.behive.entities.team.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepo extends MongoRepository<Team, String> {
}
