package com.cgi.ferme.service;



import com.cgi.ferme.domain.Fermier;

public interface IFermierService {
	
	
	public Iterable<Fermier> findAll();
	public Fermier findOne(Long id);
	Fermier saveFermier(Fermier fermier);
	public Fermier findByNom(String nom);
	public Fermier getByNomStartsWith(String nom);

}
