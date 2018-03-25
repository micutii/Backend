package com.Map.data.jpa.web.rest;

/**
 * Created by easyw on 24-Mar-18.
 */

import com.Map.data.jpa.domain.User;
import com.Map.data.jpa.service.security.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api")
@CrossOrigin
public class AuthenticationController {
    private static final Log log = LogFactory.getLog(AuthenticationController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity<User> login() {
        return new ResponseEntity<User>(HttpStatus.OK);
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<User> signedUp(@RequestBody User user) {

        user.setRole("user");
        user.setValid(true);

        if (userService.findByEmail(user.getEmail()) != null) {
            return new ResponseEntity<User>(HttpStatus.OK);
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        userService.saveUser(user);
        return new ResponseEntity<User>(HttpStatus.OK);
    }

    @RequestMapping(value = "/isAdmin", method = RequestMethod.GET)
    public ResponseEntity<Boolean> isAdmin(@RequestParam String userName) {
        User user = userService.findByEmail(userName);
        if ( user == null) {
            return new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
        }
        if(user.getRole().equals("admin")){
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        }
        return new ResponseEntity<Boolean>(false, HttpStatus.OK);
    }
}
