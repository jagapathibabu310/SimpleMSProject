package com.microservices.reviewMS.service;


import com.microservices.reviewMS.model.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService
{
    List<Review> getAllReviews(Long companyID);
    boolean addReviews (Long companyId, Review review);
    Review getReview(Long reviewID);
    boolean updateReview(Long reviewID, Review review);

    boolean deleteReview(Long reviewID);
}
