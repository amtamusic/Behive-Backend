package com.andytech.behive.controllers;

import com.andytech.behive.entities.user.Review;
import com.andytech.behive.services.ReviewService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class ReviewControllerTest {
    @InjectMocks
    @Autowired
    ReviewController reviewController = new ReviewController();

    @Mock
    ReviewService reviewService;

    @Test
    void addReviewTest() {
        Review review = new Review();
        when(reviewService.addReview(any())).thenReturn(review);
        ResponseEntity<Review> responseEntity = reviewController.addReview(review);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void deleteReviewTest() {
        Review review = new Review();
        when(reviewService.deleteReview(any())).thenReturn(true);
        ResponseEntity<Review> responseEntity = reviewController.deleteReview(review);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void updateReviewTest() {
        Review review = new Review();
        when(reviewService.updateReview(any())).thenReturn(review);
        ResponseEntity<Review> responseEntity = reviewController.updateReview(review);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void getReviewTest() {
        Review review = new Review();
        when(reviewService.getReview(any())).thenReturn(review);
        ResponseEntity<Review> responseEntity = reviewController.getReview("1");
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void getReviewTestFail() {
        Review review = new Review();
        when(reviewService.getReview(any())).thenReturn(review);
        ResponseEntity<Review> responseEntity = reviewController.getReview("a");
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }
}