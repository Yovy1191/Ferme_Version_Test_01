package com.cgi.ferme.service;



import com.cgi.ferme.domain.Animal;



public interface IAnimalService {
	
	public Iterable<Animal> findAll();
	public Animal findOne(Long id);
	Animal saveAnimal(Animal Animal);
	public void eatAllFood(Animal animal);

}
