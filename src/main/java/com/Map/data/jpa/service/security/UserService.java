package com.Map.data.jpa.service.security;

import com.Map.data.jpa.domain.User;

import java.util.List;

/**
 * Created by easyw on 24-Mar-18.
 */
public interface UserService {
    boolean saveUser(User user);

    void deleteUser(int id);

    List<User> getUsers();

    User getUser(int id);

    User findByEmail(String email);
}
