package com.cgi.ferme.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FERME")

public class Ferme extends BaseEntity {

	@Column(name = "ADRESSE")
	private String adresse;

	@OneToOne
	private Fermier fermier;

	@OneToMany(mappedBy = "ferme")
	private Set<Animal> animaux;

	// Getter - Setter


	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Fermier getFermier() {
		return fermier;
	}

	public void setFermier(Fermier fermier) {
		this.fermier = fermier;
	}

	public Set<Animal> getAnimaux() {
		return animaux;
	}

	public void setAnimaux(Set<Animal> animaux) {
		this.animaux = animaux;
	}

}
