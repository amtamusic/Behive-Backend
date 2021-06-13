package com.andytech.behive.repositories;

import com.andytech.behive.entities.user.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends MongoRepository<Review, String> {
}
