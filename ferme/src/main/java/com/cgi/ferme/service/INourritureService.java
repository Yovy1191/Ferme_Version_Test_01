package com.cgi.ferme.service;

import com.cgi.ferme.domain.Nourriture;
import com.cgi.ferme.domain.NourritureType;

public interface INourritureService {
	
	
	public Iterable<Nourriture> findAll();
	public Nourriture findOne(Long id);
	Nourriture saveNourriture(Nourriture nourriture);
  	int countByNourrituretype(NourritureType id);


}
