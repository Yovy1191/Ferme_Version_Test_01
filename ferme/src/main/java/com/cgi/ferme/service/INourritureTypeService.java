package com.cgi.ferme.service;


import com.cgi.ferme.domain.NourritureType;

public interface INourritureTypeService {
	

	public Iterable<NourritureType> findAll();
	public NourritureType findOne(Long id);
	NourritureType saveNourritureType(NourritureType nourritureType);
	public void deleteNourritureType(Long id);
	

}
