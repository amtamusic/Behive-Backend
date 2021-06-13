package com.andytech.behive.services.impl;

import com.andytech.behive.entities.user.Review;
import com.andytech.behive.repositories.ReviewRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class ReviewServiceImplTest {

    @Autowired
    @InjectMocks
    ReviewServiceImpl reviewService = new ReviewServiceImpl();

    @Mock
    ReviewRepo reviewRepo;

    @Test
    void addReviewTest() {
        Review review = new Review();
        review.setReviewText("test");
        when(reviewRepo.save(any())).thenReturn(review);
        Review response = reviewService.addReview(review);
        assertThat(response).isNotNull();
    }

    @Test
    void deleteReviewTest() throws Exception {
        Review review = new Review();
        review.setReviewText("test");
        assertThat(reviewService.deleteReview(review)).isTrue();
    }

    @Test
    void updateReviewTest() throws Exception {
        Review review = new Review();
        review.setReviewText("test");
        when(reviewRepo.save(any())).thenReturn(review);
        Review responseEntity = reviewService.updateReview(review);
        assertThat(responseEntity).isNotNull();
    }

    @Test
    void getReviewTest() throws Exception {
        Review review = new Review();
        review.setReviewText("test");
        when(reviewRepo.findById(any())).thenReturn(Optional.of(review));
        Review responseEntity = reviewService.getReview("1");
        assertThat(responseEntity).isNotNull();
    }

    @Test
    void getReviewTestNotPresent() throws Exception {
        when(reviewRepo.findById(any())).thenReturn(Optional.empty());
        Review responseEntity = reviewService.getReview("1");
        assertThat(responseEntity).isNull();
    }
}