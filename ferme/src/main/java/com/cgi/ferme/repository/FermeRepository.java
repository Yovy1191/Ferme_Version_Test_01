package com.cgi.ferme.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cgi.ferme.domain.Ferme;

@Repository
public interface FermeRepository extends CrudRepository<Ferme, Long> {

	public Ferme findByAdresse(String adress);
	public Ferme  getByAdresseStartsWith(String address);
	
}
