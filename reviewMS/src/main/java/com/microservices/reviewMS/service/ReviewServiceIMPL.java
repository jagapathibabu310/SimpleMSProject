package com.microservices.reviewMS.service;


import com.microservices.reviewMS.dao.ReviewRepository;
import com.microservices.reviewMS.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceIMPL implements ReviewService
{
    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllReviews(Long companyID)
    {
        return reviewRepository.findByCompanyId(companyID);
    }

    @Override
    public boolean addReviews(Long companyId, Review review)
    {
        if (companyId != null)
        {
            review.setCompanyID(companyId);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReview(Long reviewID)
    {
        return reviewRepository.findById(reviewID).orElse(null);
    }

    @Override
    public boolean updateReview(Long reviewID, Review updatedReview)
    {
        Review review =  reviewRepository.findById(reviewID).orElse(null);
        if (review!= null)
        {
            review.setTitle(updatedReview.getTitle());
            review.setDescription(updatedReview.getDescription());
            review.setRating(updatedReview.getRating());
            review.setCompanyID(updatedReview.getCompanyID());
            reviewRepository.save(review);
            return true;

        }
        return false;
    }

    @Override
    public boolean deleteReview(Long reviewID)
    {
        Review review = reviewRepository.findById(reviewID).orElse(null);
        if(review!= null)
        {
            reviewRepository.delete(review);
            return true;
        }
        return false;
    }
}
