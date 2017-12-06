package com.cgi.ferme.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class NourritureAnimalId implements Serializable {

	private static final long serialVersionUID = 5090281616991800259L;

	@ManyToOne
	@JoinColumn(name = "ANIMAL_ID")
	private Animal animal;

	@ManyToOne
	@JoinColumn(name = "NOURRITURE_ID")
	private Nourriture nourriture;

	// Getter - Setter

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Nourriture getNourriture() {
		return nourriture;
	}

	public void setNourriture(Nourriture nourriture) {
		this.nourriture = nourriture;
	}
}