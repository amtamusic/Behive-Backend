package com.andytech.behive.repositories;

import com.andytech.behive.entities.team.Position;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepo extends MongoRepository<Position, String> {
}
