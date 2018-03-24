package com.Map.data.jpa.service.security;

import com.Map.data.jpa.domain.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by easyw on 24-Mar-18.
 */
@Component
public class SecurityService implements UserDetailsService {
    private static final Log log = LogFactory.getLog(SecurityService.class);
    @Autowired
    private UserService userService;

    @Autowired
    public SecurityService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userService.findByEmail(username);
        log.info("User ::: " + user.getEmail());
        if (user == null) {
            throw new UsernameNotFoundException("No user present with this email: " + username);
        } else if (!user.isValid()) {
            throw new UsernameNotFoundException(username + " has been deactivated");
        } else {
            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                    new ArrayList<GrantedAuthority>(Arrays.asList(new SimpleGrantedAuthority(user.getRole()))));
        }
    }
}
