package tn.esprit.PIPFE.Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue(value = "Rapporteur")
public class Rapporteur extends Enseignant implements Serializable {
	@Override
	public String toString() {
		return "Rapporteur [nmaxrapporter=" + nmaxrapporter + ", nrapporter=" + nrapporter + ", PrefRapporterrList="
				+ PrefRapporterrList + "]";
	}

	public List<Categorie> getPrefRapporterrList() {
		return PrefRapporterrList;
	}

	public void setPrefRapporterrList(List<Categorie> prefRapporterrList) {
		PrefRapporterrList = prefRapporterrList;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int nmaxrapporter;
	private int nrapporter; 
	
	@ManyToMany
	private List<Categorie> PrefRapporterrList;

	
	public int getNmaxrapporter() {
		return nmaxrapporter;
	}

	public void setNmaxrapporter(int nmaxrapporter) {
		this.nmaxrapporter = nmaxrapporter;
	}

	public int getNrapporter() {
		return nrapporter;
	}

	public void setNrapporter(int nrapporter) {
		this.nrapporter = nrapporter;
	}

	public Rapporteur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rapporteur(int nmaxrapporter) {
		super();
		this.nmaxrapporter = nmaxrapporter;
		this.nrapporter = 0;
	}

	public Rapporteur(int nmaxrapporter, int nrapporter, List<Categorie> prefRapporterrList) {
		super();
		this.nmaxrapporter = nmaxrapporter;
		this.nrapporter = nrapporter;
		PrefRapporterrList = prefRapporterrList;
	}



	
	
	
	
}
