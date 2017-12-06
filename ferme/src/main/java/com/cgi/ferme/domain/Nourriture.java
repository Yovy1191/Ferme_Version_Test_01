package com.cgi.ferme.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "NOURRITURE")
public class Nourriture extends BaseEntity {

	@OneToMany(mappedBy = "id.animal")
	private Set<NourritureAnimal> animal;

	// Mapping - table NourritureType
	@ManyToOne
	@JoinColumn(name = "TYPE_NOURRITURE_ID")
	private NourritureType nourrituretype;

	// Getter - Setter
	public NourritureType getNourrituretype() {
		return nourrituretype;
	}

	public void setNourrituretype(NourritureType nourrituretype) {
		this.nourrituretype = nourrituretype;
	}

}
