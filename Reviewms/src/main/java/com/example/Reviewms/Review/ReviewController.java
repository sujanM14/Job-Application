package com.example.Reviewms.Review;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private ReviewService reviewService;
    public ReviewController(ReviewService reviewService){
        this.reviewService=reviewService;
    }
    

    @GetMapping("/{reviewId}")
    public  ResponseEntity<Review> getReviewById(@PathVariable Long reviewId) {
        Review review=reviewService.getReviewById(reviewId);
        if(review!=null)
        return new ResponseEntity<>(review,HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@RequestParam Long companyId) {
        return new ResponseEntity<>(reviewService.getReview(companyId),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> createReview(@RequestParam Long companyId,@RequestBody Review review) {
        boolean addedReview=reviewService.addReview(companyId,review);  
        if(addedReview)      
        return new ResponseEntity<>("Review added syccessfully",HttpStatus.OK);
        return new ResponseEntity<>("Review not added ",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReviewById(@PathVariable Long reviewId){
        boolean isDeleted=reviewService.deleteReview(reviewId);
        if(isDeleted){
            return new ResponseEntity<>("Review deleted syccessfully",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewId, @RequestBody Review updatedReview) {
        boolean isUpdated=reviewService.updateReview(reviewId,updatedReview);
        if(isUpdated){
            return new ResponseEntity<>("Review updates syccessfully",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    
}
