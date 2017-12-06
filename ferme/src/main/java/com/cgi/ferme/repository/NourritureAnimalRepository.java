package com.cgi.ferme.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cgi.ferme.domain.NourritureAnimal;



@Repository
public interface NourritureAnimalRepository extends CrudRepository<NourritureAnimal, Long> {

}
