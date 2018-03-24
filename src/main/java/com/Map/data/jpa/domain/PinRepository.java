package com.Map.data.jpa.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PinRepository extends CrudRepository<Pin, Integer> {

	List<Pin> findAll();

	List<Pin> findByIdType(int idType);
}
