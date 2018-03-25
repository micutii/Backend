package com.Map.data.jpa.web.rest;

import com.Map.data.jpa.domain.Photo;
import com.Map.data.jpa.domain.Pin;
import com.Map.data.jpa.domain.User;
import com.Map.data.jpa.service.Photo.PhotoService;
import com.Map.data.jpa.service.Pin.PinService;
import com.Map.data.jpa.service.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by easyw on 25-Mar-18.
 */
@Controller
@RequestMapping(value = "/api/photos",
        produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class PhotoRestController {
    @Autowired
    private UserService userService;
    @Autowired
    private PhotoService photoService;

    @RequestMapping(
            value = "/get",
            method = RequestMethod.GET)
    public ResponseEntity<List<Photo>> getAll(@RequestParam("idPin") int idPin){
        List<Photo> photos = photoService.getAllFromPin(idPin);
        if(photos.isEmpty()){
            return new ResponseEntity<List<Photo>>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<List<Photo>>(photos, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/create",
            method = RequestMethod.POST)
    public ResponseEntity<Photo> createPhoto(@RequestBody Photo photo, @RequestParam("user") String userName) {
        User user = userService.findByEmail(userName);
        if (user == null) {
            return new ResponseEntity<Photo>(HttpStatus.UNAUTHORIZED);
        }
        photo.setUserName(userName);
        photo.setState(user.getRole().equals("user")? 0 : 1);
        if(photoService.savePhoto(photo)){
            return new ResponseEntity<Photo>(photo, HttpStatus.CREATED);
        }
        return new ResponseEntity<Photo>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(
            value = "/update/{id}",
            method = RequestMethod.PUT)
    public ResponseEntity<Photo> updatePhoto(@PathVariable("id") int idPhoto){
        Photo photo = photoService.getPhoto(idPhoto);
        if(photo == null){
            return new ResponseEntity<Photo>(HttpStatus.NOT_FOUND);
        }
        else{
            photo.setState(1);
            photoService.savePhoto(photo);
            return new ResponseEntity<Photo>(photo, HttpStatus.OK);
        }
    }

    @RequestMapping(
            value = "/delete/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Photo> createPhoto(@PathVariable("id") int idPhoto){
        photoService.removePin(idPhoto);
        return new ResponseEntity<Photo>(HttpStatus.OK);
    }
}
