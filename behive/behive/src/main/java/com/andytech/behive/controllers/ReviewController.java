package com.andytech.behive.controllers;

import com.andytech.behive.entities.user.Review;
import com.andytech.behive.services.ReviewService;
import com.andytech.behive.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    LogUtils logUtils;

    public ReviewController() {
        this.logUtils = new LogUtils();
        this.logUtils.setLoggerClass(this.getClass());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Review> getReview(@PathVariable("id") String id) {
        logUtils.logString(String.format("Update Review received: %s", id));
        var review = reviewService.getReview(id);
        logUtils.logObject("Returned review after lookup by id : %s", review);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<Review> addReview(@RequestBody Review review) {
        logUtils.logObject("Add Review received: %s", review);
        review = reviewService.addReview(review);
        logUtils.logObject("Add Review result: %s", review);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<Review> updateReview(@RequestBody Review review) {
        logUtils.logObject("Update Review received: %s", review);
        review = reviewService.updateReview(review);
        logUtils.logObject("Update Review result: %s", review);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public ResponseEntity<Review> deleteReview(@RequestBody Review review) {
        logUtils.logObject("Delete Review received: %s", review);
        reviewService.deleteReview(review);
        logUtils.logString("Review " + review.toString() + " deleted");
        return new ResponseEntity<>(review, HttpStatus.OK);
    }
}
