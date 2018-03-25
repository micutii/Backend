package com.Map.data.jpa.service.review;

import com.Map.data.jpa.domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by easyw on 25-Mar-18.
 */

public interface ReviewService {

    List<Review> getTopReviews(int idPin);

    boolean saveReview(Review review);

    Review getReview(int idReview);

    void removeReview(int idReview);
}
