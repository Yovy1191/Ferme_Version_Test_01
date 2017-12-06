package com.cgi.ferme.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.ferme.domain.Animal;
import com.cgi.ferme.domain.NourritureAnimal;
import com.cgi.ferme.repository.AnimalRepository;
import com.cgi.ferme.service.IAnimalService;
import com.cgi.ferme.service.INourritureAnimalService;

@Service
public class AnimalServiceImpl implements IAnimalService {

	// Importer le singleton dans app
	@Autowired
	private AnimalRepository animalRepository;

	// Importer le singleton dans app
	@Autowired
	private INourritureAnimalService nourritureanimalService;

	@Override
	public Iterable<Animal> findAll() {
		return animalRepository.findAll();
	}

	@Override
	public Animal findOne(Long id) {
		return animalRepository.findOne(id);
	}

	@Override
	public Animal saveAnimal(Animal Animal) {
		return animalRepository.save(Animal);
	}

	@Override
	public void eatAllFood(Animal animal) {
		{
			Set<NourritureAnimal> nourritures;
			int total;
			long valeur = 0;
			total = 0;
			nourritures = animal.getNourriture();
			if (!nourritures.isEmpty()) {
				for (NourritureAnimal nourriture : nourritures) {
					valeur = nourriture.getId().getNourriture().getNourrituretype().getValeur_Nutritrionelle();
					total += nourriture.getQuantite() * valeur;

				}

				nourritureanimalService.delete(nourritures);
			}
			animal.setNourritureConsomme(total);
		}

	}

}
