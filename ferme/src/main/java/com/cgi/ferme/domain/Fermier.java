package com.cgi.ferme.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FERMIER")

public class Fermier extends BaseEntity {

	@Column(name = "NOM")
	private String nom;

	@Column(name = "AGE")
	private String age;

	@OneToOne(mappedBy = "fermier")
	private Ferme ferme;

	// Getter - Setter

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}