package com.cgi.ferme.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ANIMAL")
public class Animal extends BaseEntity {

	@Column(name = "NOURRITURE_CONSOMME")
	private int nourritureConsomme;

	@ManyToOne
	@JoinColumn(name = "FERME_ID")
	private Ferme ferme;

	@ManyToOne
	@JoinColumn(name = "TYPE_ANIMAL_ID")
	private TypeAnimal type;

	@OneToMany(mappedBy = "id.animal")
	private Set<NourritureAnimal> nourriture;

	// Getter - Setter

	public int getNourritureConsomme() {
		return nourritureConsomme;
	}

	public void setNourritureConsomme(int nourritureConsomme) {
		this.nourritureConsomme = nourritureConsomme;
	}

	public TypeAnimal getType() {
		return type;
	}

	public void setType(TypeAnimal type) {
		this.type = type;
	}

	public Ferme getFerme() {
		return ferme;
	}

	public void setFerme(Ferme ferme) {
		this.ferme = ferme;
	}

	public Set<NourritureAnimal> getNourriture() {
		return nourriture;
	}

	public void setNourriture(Set<NourritureAnimal> nourriture) {
		this.nourriture = nourriture;
	}

}
