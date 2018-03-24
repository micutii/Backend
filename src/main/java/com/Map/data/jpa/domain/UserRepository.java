package com.Map.data.jpa.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findAll();
    User findByIdUser(int id);
    User findByEmail(String email);
    List<User> findByFullName(String fullName);
}
