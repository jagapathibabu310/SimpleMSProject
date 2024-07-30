package com.microservices.reviewMS.controller;


import com.microservices.reviewMS.model.Review;
import com.microservices.reviewMS.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController
{
    @Autowired
    ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId)
    {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addReviews(@RequestParam Long companyId, @RequestBody Review review)
    {
        boolean isReviewSaved = reviewService.addReviews(companyId,review);
        if(isReviewSaved)
            return new ResponseEntity<>("Review Added Successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Review Not Saved ", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{reviewID}")
    public ResponseEntity<Review> getReview(@PathVariable Long reviewID)
    {
        return new ResponseEntity<>(reviewService.getReview(reviewID), HttpStatus.OK );
    }

    @PutMapping("/{reviewID}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewID,
                                               @RequestBody Review review)
    {
        boolean isReviewUpdated = reviewService.updateReview(reviewID,review);
        if(isReviewUpdated)
        {
            return new ResponseEntity<>("Review Updated Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review Not Updated Successfully", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview (@PathVariable Long reviewID)
    {
        boolean isReviewDeleted = reviewService.deleteReview(reviewID);
        if(isReviewDeleted)
        {
            return new ResponseEntity<>("Review Deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review Not Deleted", HttpStatus.NOT_FOUND);
    }
}
