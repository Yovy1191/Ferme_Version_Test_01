package com.cgi.ferme.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cgi.ferme.domain.Nourriture;
import com.cgi.ferme.domain.NourritureType;

@Repository
public interface NourritureRepository extends CrudRepository<Nourriture, Long> {
	
    int countByNourrituretype(NourritureType id);
	  

}
