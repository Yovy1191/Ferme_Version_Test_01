package com.cgi.ferme.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cgi.ferme.domain.Animal;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Long> {

}
