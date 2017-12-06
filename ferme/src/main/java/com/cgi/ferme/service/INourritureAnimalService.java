package com.cgi.ferme.service;


import java.util.Set;
import com.cgi.ferme.domain.NourritureAnimal;



public interface INourritureAnimalService {
	
	public Iterable<NourritureAnimal> findAll();
	
	public NourritureAnimal findOne(Long id);
	
	NourritureAnimal saveNourritureAnimal(NourritureAnimal nourritureanimal);
	
	public void delete(Set<NourritureAnimal> na);
	
}
