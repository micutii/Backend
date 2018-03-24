package com.Map.data.jpa.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PinRepository extends CrudRepository<Pin, Integer> {

	List<Pin> findAll();

	List<Pin> findByIdType(int idType);
	List<Pin> findByState(int state);
	@Query("select p from Pin p where p.state = 1")
    List<Pin> findValidPins();
}
