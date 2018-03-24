package com.Map.data.jpa.service.security;

import com.Map.data.jpa.domain.User;

/**
 * Created by easyw on 24-Mar-18.
 */
public interface UserService {
    User save(User user);

    void delete(int id);

    User findById(int id);

    User findByEmail(String email);
}
