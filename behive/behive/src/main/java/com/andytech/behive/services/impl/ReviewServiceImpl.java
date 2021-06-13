package com.andytech.behive.services.impl;

import com.andytech.behive.entities.user.Review;
import com.andytech.behive.repositories.ReviewRepo;
import com.andytech.behive.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;

    @Override
    public Review getReview(String id) {
        Optional<Review> review = reviewRepo.findById(id);
        if (review.isPresent()) {
            return review.get();
        }
        return null;
    }

    @Override
    public Review addReview(Review review) {
        return reviewRepo.save(review);
    }

    @Override
    public Review updateReview(Review review) {
        return reviewRepo.save(review);
    }

    @Override
    public boolean deleteReview(Review review) {
        reviewRepo.delete(review);
        return true;
    }
}
