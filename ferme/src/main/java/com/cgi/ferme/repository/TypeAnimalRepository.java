package com.cgi.ferme.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cgi.ferme.domain.TypeAnimal;

@Repository
public interface TypeAnimalRepository extends CrudRepository<TypeAnimal, Long> {

}
