package com.Map.data.jpa.web.rest;

import com.Map.data.jpa.domain.Pin;
import com.Map.data.jpa.service.Pin.PinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
@RequestMapping(value = "/api/pins",
        produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class PinRestController {

    @Autowired
    private PinService pinService;

    @RequestMapping(
            value = "/get",
            method = RequestMethod.GET)
    public ResponseEntity<List<Pin>> get(@RequestParam(value = "type", required = false) Integer idType){
        List<Pin> pins = pinService.getPins(idType);
        if(pins.isEmpty())
        {
            return new ResponseEntity<List<Pin>>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<List<Pin>>(pins, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/create",
            method = RequestMethod.POST)
    public ResponseEntity<Pin> createPin(@RequestBody Pin pin){

        if(pinService.savePin(pin))
        {
            return new ResponseEntity<Pin>(pin, HttpStatus.CREATED);
        }
        return new ResponseEntity<Pin>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(
            value = "/update/{id}",
            method = RequestMethod.PUT)
    public ResponseEntity<Pin> updatePin(@PathVariable("id") int idPin, @RequestBody Pin pin){
        Pin oldPin = pinService.getPin(idPin);
        if(oldPin == null){
            return new ResponseEntity<Pin>(HttpStatus.NOT_FOUND);
        }
        else{
            pin.setIdPin(idPin);
            pinService.savePin(pin);
            return new ResponseEntity<Pin>(pin, HttpStatus.OK);
        }
    }

    @RequestMapping(
            value = "/delete/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Pin> createPin(@PathVariable("id") int idPin){

        pinService.removePin(idPin);
        return new ResponseEntity<Pin>(HttpStatus.OK);
    }

}
