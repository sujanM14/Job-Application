package com.example.Reviewms.Review;

import java.util.List;

public interface ReviewService {
    Review getReviewById(Long reviewId);
    boolean addReview(Long companyId,Review review);
    boolean updateReview(Long reviewId,Review updatedReview);
    boolean deleteReview(Long reviewId);
    List<Review> getReview(Long companyId);
    
}
