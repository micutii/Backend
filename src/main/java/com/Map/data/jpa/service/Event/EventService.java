package com.Map.data.jpa.service.Event;

import com.Map.data.jpa.domain.Event;

import java.util.List;

/**
 * Created by easyw on 24-Mar-18.
 */
public interface EventService {
    Event getEvent(int id);

    List<Event> getEvents();

    boolean saveEvent(Event event);

    void removeEvent(int idEvent);
}
