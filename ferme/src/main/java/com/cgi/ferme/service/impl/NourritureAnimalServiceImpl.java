package com.cgi.ferme.service.impl;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cgi.ferme.domain.NourritureAnimal;
import com.cgi.ferme.repository.NourritureAnimalRepository;
import com.cgi.ferme.service.INourritureAnimalService;


@Service
public class NourritureAnimalServiceImpl implements INourritureAnimalService {

	//Importer le singleton dans app 
	@Autowired
	private NourritureAnimalRepository nourritureAnimalRepository;

	@Override
	public Iterable<NourritureAnimal> findAll() {
		return  nourritureAnimalRepository.findAll();
	}
	
	@Override
	public NourritureAnimal findOne(Long id) {
		return nourritureAnimalRepository.findOne(id);
	}

	@Override
	public NourritureAnimal saveNourritureAnimal(NourritureAnimal nourritureanimal) {
		  return nourritureAnimalRepository.save(nourritureanimal);
	}

	@Override
	public void delete(Set<NourritureAnimal> nourritureanimal) {
		nourritureAnimalRepository.delete(nourritureanimal);
		
	}

	
	


}
