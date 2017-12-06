package com.cgi.ferme.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.ferme.domain.TypeAnimal;
import com.cgi.ferme.repository.TypeAnimalRepository;
import com.cgi.ferme.service.ITypeAnimalService;

@Service
public class TypeAnimalServiceImpl implements ITypeAnimalService {

	// Importer le singleton dans app
	@Autowired
	private TypeAnimalRepository typeanimalRepository;

	@Override
	public Iterable<TypeAnimal> findAll() {
		return typeanimalRepository.findAll();
	}

	@Override
	public TypeAnimal findOne(Long id) {
		return typeanimalRepository.findOne(id);
	}

	@Override
	public TypeAnimal saveTypeAnimal(TypeAnimal typeAnimal) {
		return typeanimalRepository.save(typeAnimal);
	}

}
