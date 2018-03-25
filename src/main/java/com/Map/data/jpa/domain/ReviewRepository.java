package com.Map.data.jpa.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by easyw on 25-Mar-18.
 */
public interface ReviewRepository extends CrudRepository<Review, Integer> {
    List<Review> findAll();

    List<Review> findByIdPinOrderByRatingDesc(int idPin);

}
