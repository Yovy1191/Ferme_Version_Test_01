package com.cgi.ferme.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cgi.ferme.domain.Fermier;

@Repository
public interface FermierRepository extends CrudRepository<Fermier, Long> {
	
	public Fermier findByNom(String nom);
	public Fermier getByNomStartsWith(String nom);
	
	}
