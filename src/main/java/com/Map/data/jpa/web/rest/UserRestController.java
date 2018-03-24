package com.Map.data.jpa.web.rest;

import com.Map.data.jpa.domain.User;
import com.Map.data.jpa.service.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by easyw on 24-Mar-18.
 */
@Controller
@RequestMapping(value = "/api/users",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRestController {

    @Autowired
    UserService userService;

    @RequestMapping(
            value = "/get/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<User> getOne(@PathVariable("id") int idUser){
        User user = userService.getUser(idUser);
        if(user == null)
        {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/get",
            method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAll(){
        List<User> users = userService.getUsers();
        if(users.isEmpty())
        {
            return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
    @RequestMapping(
            value = "/create",
            method = RequestMethod.POST)
    public ResponseEntity<User> createType(@RequestBody User user){
        if(userService.saveUser(user))
        {
            return new ResponseEntity<User>(user, HttpStatus.CREATED);
        }
        return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(
            value = "/update/{id}",
            method = RequestMethod.PUT)
    public ResponseEntity<User> updateType(@PathVariable("id") int idUser, @RequestBody User user){
        User oldUser = userService.getUser(idUser);
        if(oldUser== null){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        else{
            user.setIdUser(idUser);
            userService.saveUser(user);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
    }

    @RequestMapping(
            value = "/delete/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<User> createPin(@PathVariable("id") int idUser){

        userService.deleteUser(idUser);
        return new ResponseEntity<User>(HttpStatus.OK);
    }
}
