package com.Map.data.jpa.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by easyw on 25-Mar-18.
 */
public interface PhotoRepository extends CrudRepository<Photo, Integer> {
    List<Photo> getByIdPin(int idPin);
}
