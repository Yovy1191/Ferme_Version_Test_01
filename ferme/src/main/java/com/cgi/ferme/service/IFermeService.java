package com.cgi.ferme.service;




import com.cgi.ferme.domain.Ferme;

public interface IFermeService {

  	public Iterable<Ferme> findAll();
	public Ferme findOne(Long id);
	Ferme saveFerme(Ferme ferme);
	public void eatAllFoodAvailable(Ferme ferme_eat);
	public Ferme findByAdresse(String adresse);
	public Ferme getByAdresseStartsWith(String adresse);
		
}
