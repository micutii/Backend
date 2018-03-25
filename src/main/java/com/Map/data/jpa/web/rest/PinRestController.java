package com.Map.data.jpa.web.rest;

import com.Map.data.jpa.domain.Pin;
import com.Map.data.jpa.domain.User;
import com.Map.data.jpa.service.Pin.PinService;
import com.Map.data.jpa.service.security.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private static final Log log = LogFactory.getLog(PinRestController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private PinService pinService;

    @RequestMapping(
            value = "/getValid",
            method = RequestMethod.GET)
    public ResponseEntity<List<Pin>> getValid(){
        List<Pin> pins = pinService.getValidPins();
        if(pins.isEmpty()){
            return new ResponseEntity<List<Pin>>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<List<Pin>>(pins, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/get",
            method = RequestMethod.GET)
    public ResponseEntity<List<Pin>> getAll(){
        List<Pin> pins = pinService.getPins();
        if(pins.isEmpty()){
            return new ResponseEntity<List<Pin>>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<List<Pin>>(pins, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/create",
            method = RequestMethod.POST)
    public ResponseEntity<Pin> createPin(@RequestBody Pin pin){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(authentication.getName());
        if(user == null ){
            return new ResponseEntity<Pin>(HttpStatus.UNAUTHORIZED);
        }
        pin.setUserName(user.getEmail());
        pin.setState(user.getRole().equals("user")? 0 : 1);
        if(pinService.savePin(pin)){
            return new ResponseEntity<Pin>(pin, HttpStatus.CREATED);
        }
        return new ResponseEntity<Pin>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(
            value = "/update/{id}",
            method = RequestMethod.PUT)
    public ResponseEntity<Pin> updatePin(@PathVariable("id") int idPin){
        Pin pin = pinService.getPin(idPin);
        if(pin == null){
            return new ResponseEntity<Pin>(HttpStatus.NOT_FOUND);
        }
        else{
            pin.setState(1);
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
