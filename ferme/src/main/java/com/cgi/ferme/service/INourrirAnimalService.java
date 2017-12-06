package com.cgi.ferme.service;

import com.cgi.ferme.domain.Ferme;


public interface INourrirAnimalService {
	
	
	public Iterable<Ferme> findAll();
	public Ferme findOne(Long id);
	
}
