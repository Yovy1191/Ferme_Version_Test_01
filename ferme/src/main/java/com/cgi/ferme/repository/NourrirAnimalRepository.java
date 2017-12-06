package com.cgi.ferme.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.cgi.ferme.domain.Ferme;

@Repository
public interface NourrirAnimalRepository extends CrudRepository<Ferme, Long> {

}
