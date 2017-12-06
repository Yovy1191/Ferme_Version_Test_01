package com.cgi.ferme.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TYPE_ANIMAL")
public class TypeAnimal extends BaseEntity {

	@Column
	private String nom;

	@OneToMany(mappedBy = "type")
	private Set<Animal> animaux;

	// Getter - Setter

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
