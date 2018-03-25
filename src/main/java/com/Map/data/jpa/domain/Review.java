package com.Map.data.jpa.domain;

import javax.persistence.*;

/**
 * Created by easyw on 24-Mar-18.
 */
@Entity(name = "REVIEW")
public class Review {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "ID_REVIEW")
        private int idReview;
        @Column(name = "ID_PIN")
        private int idPin;
        @Column(name = "RATING")
        private int rating;
        @Column(name = "FEEDBACK")
        private String details;;
        @Column(name = "USER_NAME")
        private String userName;
        @Column(name = "SENTIMENT")
        private String sentiment;
        @Column(name = "CONFIDENCE")
        private Double confidence;

    public int getIdReview() {
        return idReview;
    }

    public void setIdReview(int idReview) {
        this.idReview = idReview;
    }

    public int getIdPin() {
        return idPin;
    }

    public void setIdPin(int idPin) {
        this.idPin = idPin;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }
}
