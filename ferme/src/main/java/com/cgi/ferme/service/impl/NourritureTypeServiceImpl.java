package com.cgi.ferme.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.ferme.domain.NourritureType;
import com.cgi.ferme.repository.NourritureTypeRepository;
import com.cgi.ferme.service.INourritureTypeService;

@Service
public class NourritureTypeServiceImpl implements INourritureTypeService {

	// Importer le singleton dans app
	@Autowired
	private NourritureTypeRepository nourrituretypeRepository;

	@Override
	public Iterable<NourritureType> findAll() {
		return nourrituretypeRepository.findAll();
	}

	@Override
	public NourritureType findOne(Long id) {
		return nourrituretypeRepository.findOne(id);
	}

	@Override
	public NourritureType saveNourritureType(NourritureType nourritureType) {
 	return nourrituretypeRepository.save(nourritureType);
	}

	@Override
	public void deleteNourritureType(Long id) {
	    nourrituretypeRepository.delete(id);
	}

	

	

}
