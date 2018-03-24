package com.Map.data.jpa.web.rest;

import com.Map.data.jpa.domain.Event;
import com.Map.data.jpa.service.Event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by easyw on 24-Mar-18.
 */
@Controller
@RequestMapping(value = "/api/events",
        produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class EventRestController {

    @Autowired
    EventService eventService;

    @RequestMapping(
            value = "/get",
            method = RequestMethod.GET)
    public ResponseEntity<List<Event>> getAll(){
        List<Event> events = eventService.getEvents();
        if(events.isEmpty()){
            return new ResponseEntity<List<Event>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Event>>(events,HttpStatus.OK);
    }

    @RequestMapping(
            value = "/create",
            method = RequestMethod.POST)
    public ResponseEntity<Event> createEvent(@RequestBody Event event){
                if(eventService.saveEvent(event)){
                    return new ResponseEntity<Event>(event, HttpStatus.OK);
                }
                return new ResponseEntity<Event>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(
            value = "/update/{id}",
            method = RequestMethod.PUT)
    public ResponseEntity<Event> updateEvent(@PathVariable("id") int idEvent, @RequestBody Event event){
                Event oldEvent = eventService.getEvent(idEvent);
        if(oldEvent == null){
            return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
        }
        else{
            event.setIdEvent(idEvent);
            eventService.saveEvent(event);
            return new ResponseEntity<Event>(event,HttpStatus.OK);
        }
    }

    @RequestMapping(
            value = "/delete/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Event> createPin(@PathVariable("id") int idEvent){

        eventService.removeEvent(idEvent);
        return new ResponseEntity<Event>(HttpStatus.OK);
    }
}
