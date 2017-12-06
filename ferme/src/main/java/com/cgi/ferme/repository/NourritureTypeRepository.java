package com.cgi.ferme.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.cgi.ferme.domain.NourritureType;

@Repository
public interface NourritureTypeRepository extends CrudRepository<NourritureType, Long> {

}
