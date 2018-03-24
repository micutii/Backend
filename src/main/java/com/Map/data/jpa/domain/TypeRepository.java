package com.Map.data.jpa.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TypeRepository extends CrudRepository<Type, Integer> {

    List<Type> findAll();
    List<Type> findByIdType(int idType);
    List<Type> findByTypeName(String name);
}
