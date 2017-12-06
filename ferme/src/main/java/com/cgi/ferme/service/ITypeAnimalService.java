package com.cgi.ferme.service;


import com.cgi.ferme.domain.TypeAnimal;

public interface ITypeAnimalService {
	
	public Iterable<TypeAnimal> findAll();
	public TypeAnimal findOne(Long id);
	TypeAnimal saveTypeAnimal(TypeAnimal typeAnimal);
	
}
