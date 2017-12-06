package com.cgi.ferme.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.ferme.domain.Nourriture;
import com.cgi.ferme.domain.NourritureType;
import com.cgi.ferme.repository.NourritureRepository;
import com.cgi.ferme.service.INourritureService;

@Service
public class NourritureServiceImpl implements INourritureService {

	// Importer le singleton dans app
	@Autowired
	private NourritureRepository nourritureRepository;

	@Override
	public Iterable<Nourriture> findAll() {
		return nourritureRepository.findAll();
	}

	@Override
	public Nourriture findOne(Long id) {
		return nourritureRepository.findOne(id);

	}

	@Override
	public Nourriture saveNourriture(Nourriture nourriture) {
		return nourritureRepository.save(nourriture);
	}

	@Override
	public int countByNourrituretype(NourritureType id) {
		return nourritureRepository.countByNourrituretype(id);
	}


}
