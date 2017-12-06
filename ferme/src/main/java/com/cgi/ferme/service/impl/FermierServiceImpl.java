package com.cgi.ferme.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cgi.ferme.domain.Fermier;
import com.cgi.ferme.repository.FermierRepository;
import com.cgi.ferme.service.IFermierService;

@Service
public class FermierServiceImpl implements IFermierService {

	// Importer le singleton dans app
	@Autowired
	private FermierRepository fermierRepository;

	@Override
	public Iterable<Fermier> findAll() {
		return fermierRepository.findAll();
	}

	@Override
	public Fermier findOne(Long id) {
		return fermierRepository.findOne(id);
	}

	@Override
	public Fermier saveFermier(Fermier fermier) {
		return fermierRepository.save(fermier);
	}

	@Override
	public Fermier findByNom(String nom) {
		return fermierRepository.findByNom(nom);
	}

	@Override
	public Fermier getByNomStartsWith(String nom) {
		return fermierRepository.getByNomStartsWith(nom);
	}

}
