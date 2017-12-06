package com.cgi.ferme.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "NOURRITURE_ANIMAL")
public class NourritureAnimal implements Serializable {

	private static final long serialVersionUID = -8118807328049716893L;

	@EmbeddedId
	@Id
	@GeneratedValue
	private NourritureAnimalId id;

	@JoinColumn(name = "QUANTITE")
	private long quantite;

	// Getter - Setter

	public NourritureAnimalId getId() {
		return id;
	}

	public void setId(NourritureAnimalId id) {
		this.id = id;
	}

	public long getQuantite() {
		return quantite;
	}

	public void setQuantite(long quantite) {
		this.quantite = quantite;
	}
}