package com.example.Reviewms.Review.impl;

import java.util.List;


import org.springframework.stereotype.Service;


import com.example.Reviewms.Review.Review;
import com.example.Reviewms.Review.ReviewRepository;
import com.example.Reviewms.Review.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;

    private Long nextId=1L;
    public ReviewServiceImpl (ReviewRepository reviewRepository){
        this.reviewRepository=reviewRepository;
    }
    @Override
    public Review getReviewById(Long reviewIid) {
        return reviewRepository.findById(reviewIid).orElse(null);
        
    }
    
    @Override
    public boolean addReview(Long companyId,Review review) {
        review.setId(nextId++);
        if(companyId!=null && review!=null){
            review.setCompanyId(companyId);
            reviewRepository.save(review);
            return true;
        }
        return false;
       

    }
    @Override
    public boolean updateReview(Long reviewId,Review updatedReview) {
       Review review=reviewRepository.findById(reviewId).orElse(null);
        if(reviewId!=null){
            review.setTitle(updatedReview.getTitle());
            review.setDescription(updatedReview.getDescription());
            review.setRating(updatedReview.getRating());
            review.setCompanyId(updatedReview.getCompanyId());
            reviewRepository.save(review);

            return true;
        }
        return false;
    }
    @Override
    public boolean deleteReview(Long reviewId) {
        Review review=reviewRepository.findById(reviewId).orElse(null);
        if(review!=null){
            reviewRepository.deleteById(reviewId);
            return true;
        }else{
           return false;
        }
    }
    @Override
    public List<Review> getReview(Long companyId) {
        List<Review> reviews=reviewRepository.findBycompanyId(companyId);
        
       return reviews;
    }
}
