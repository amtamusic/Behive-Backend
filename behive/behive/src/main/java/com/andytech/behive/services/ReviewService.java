package com.andytech.behive.services;

import com.andytech.behive.entities.user.Review;

public interface ReviewService {

    Review getReview(String id);

    Review addReview(Review review);

    Review updateReview(Review review);

    boolean deleteReview(Review review);
}
