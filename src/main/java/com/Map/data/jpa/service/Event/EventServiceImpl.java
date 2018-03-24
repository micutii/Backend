package com.Map.data.jpa.service.Event;

import com.Map.data.jpa.domain.Event;
import com.Map.data.jpa.domain.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by easyw on 24-Mar-18.
 */
@Component
public class EventServiceImpl implements EventService{

    @Autowired
    private EventRepository eventRepository;
    @Override
    public Event getEvent(int id) {
        return eventRepository.findOne(id);
    }

    @Override
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    @Override
    public boolean saveEvent(Event event) {
        if(eventRepository.save(event) != null){
            return true;
        }
        return false;
    }

    @Override
    public void removeEvent(int idEvent) {
        eventRepository.delete(idEvent);
    }
}
