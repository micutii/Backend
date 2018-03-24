package com.Map.data.jpa.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findAll();
    List<User> findByIdUser(int id);
    List<User> findByEmail(String email);
    List<User> findByAdmin(boolean isAdmin);
    List<User> findByFullName(String fullName);
}
