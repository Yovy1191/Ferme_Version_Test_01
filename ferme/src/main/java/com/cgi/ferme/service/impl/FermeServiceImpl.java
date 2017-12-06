package com.cgi.ferme.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.ferme.domain.Animal;
import com.cgi.ferme.domain.Ferme;
import com.cgi.ferme.repository.FermeRepository;
import com.cgi.ferme.service.IAnimalService;
import com.cgi.ferme.service.IFermeService;

@Service
public class FermeServiceImpl implements IFermeService {

	// Importer le singleton dans app
	@Autowired
	private FermeRepository fermeRepository;

	@Autowired
	private IAnimalService animalService;

	@Override
	public Iterable<Ferme> findAll() {
		return fermeRepository.findAll();
	}

	@Override
	public Ferme findOne(Long id) {
		return fermeRepository.findOne(id);
	}

	@Override
	public void eatAllFoodAvailable(Ferme ferme_eat) {
		Set<Animal> animaux = ferme_eat.getAnimaux();

		for (Animal animal : animaux) {
			animalService.eatAllFood(animal);

		}
	}
	
	@Override
	public Ferme saveFerme(Ferme ferme) {
		return fermeRepository.save(ferme);
	}

	@Override
	public Ferme findByAdresse(String adresse) {
		return fermeRepository.findByAdresse(adresse);
	}

	@Override
	public Ferme getByAdresseStartsWith(String adresse) {
		return fermeRepository.getByAdresseStartsWith(adresse); 
	}

	
}
