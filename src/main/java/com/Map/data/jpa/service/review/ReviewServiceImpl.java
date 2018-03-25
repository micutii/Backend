package com.Map.data.jpa.service.review;

import com.Map.data.jpa.domain.Review;
import com.Map.data.jpa.domain.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by easyw on 25-Mar-18.
 */
@Component
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    public ReviewRepository reviewRepository;
    @Override
    public List<Review> getTopReviews(int idPin) {

        List<Review> review = reviewRepository.findByIdPinAndSentimentOrderByConfidenceDesc(idPin, "Positive");
        review.addAll(reviewRepository.findByIdPinAndSentimentOrderByConfidenceDesc(idPin, "Neutral"));
        review.addAll(reviewRepository.findByIdPinAndSentimentOrderByConfidenceDesc(idPin, "Negative"));
        return review;
    }


    @Override
    public boolean saveReview(Review review) {
        if(reviewRepository.save(review) != null){
            return true;
        }
        return false;
    }

    @Override
    public Review getReview(int idReview) {
        return reviewRepository.findById(idReview).get();
    }

    @Override
    public void removeReview(int idReview) {
        reviewRepository.deleteById(idReview);
    }
}
