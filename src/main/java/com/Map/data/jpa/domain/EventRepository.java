package com.Map.data.jpa.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Integer> {

    List<Event> findAll();
    List<Event> findByIdEvent(int id);
    List<Event> findByApproved(boolean approved);
    List<Event> findByIdPin(int idPin);
}
