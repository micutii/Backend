package com.Map.data.jpa.web.rest;

import com.Map.data.jpa.domain.Event;
import com.Map.data.jpa.domain.Review;
import com.Map.data.jpa.domain.User;
import com.Map.data.jpa.service.review.ReviewService;
import com.Map.data.jpa.service.security.UserService;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by easyw on 25-Mar-18.
 */
@RestController
@RequestMapping(value = "/api/reviews",
        produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class ReviewRestController {
    private static final Log log = LogFactory.getLog(ReviewRestController.class);
    @Autowired
    ReviewService reviewService;
    @Autowired
    UserService userService;

    @RequestMapping(
            value = "/get",
            method = RequestMethod.GET)
    public ResponseEntity<List<Review>> getAll(@RequestParam("idPin") int idPin){
        List<Review> reviews = reviewService.getTopReviews(idPin);
        if(reviews.isEmpty()){
            return new ResponseEntity<List<Review>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Review>>(reviews, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/create",
            method = RequestMethod.POST)
    public ResponseEntity<Review> createReview(@RequestParam("idPin") int idPin, @RequestParam("user") String userName,
                                               @RequestBody Review review){
        User user = userService.findByEmail(userName);
        try {
            HttpResponse<JsonNode> response = Unirest.post("https://community-sentiment.p.mashape.com/text/")
                    .header("X-Mashape-Key", "Wjcxt8uJFJmsh8SYClq2XIZO3uBLp1dBiFfjsn7Iwu1RCsBGrs")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Accept", "application/json")
                    .field("txt", review.getFeedback())
                    .asJson();
            JSONObject result = response.getBody().getArray().getJSONObject(0).getJSONObject("result");
            String sentiment = result.get("sentiment").toString();
            String confidence = result.get("confidence").toString();
            log.info("S: " + sentiment + "  C: " + confidence);
            review.setConfidence(confidence);
            review.setSentiment(sentiment);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        review.setUserName(user.getEmail());
        if(reviewService.saveReview(review)){
            return new ResponseEntity<Review>(review, HttpStatus.OK);
        }
        return new ResponseEntity<Review>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(
            value = "/update/{id}",
            method = RequestMethod.PUT)
    public ResponseEntity<Review> updatePin(@PathVariable("id") int idReview, @RequestBody Review review){
        Review oldReview = reviewService.getReview(idReview);
        if(oldReview == null){
            return new ResponseEntity<Review>(HttpStatus.NOT_FOUND);
        }
        else{
            review.setIdReview(idReview);
            reviewService.saveReview(review);
            return new ResponseEntity<Review>(review, HttpStatus.OK);
        }
    }

    @RequestMapping(
            value = "/delete/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Review> deleteReview(@PathVariable("id") int idReview){
        reviewService.removeReview(idReview);
        return new ResponseEntity<Review>(HttpStatus.OK);
    }
}
