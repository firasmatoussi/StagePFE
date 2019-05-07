package tn.esprit.PIPFE.Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue(value = "Encadrant")
public class Encadrant extends Enseignant implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToMany
	private List<Categorie> PrefEncadrerrList;
	
	private int nmaxEncadrer;
	private int nEncadrer;
	
	
	public List<Categorie> getPrefEncadrerrList() {
		return PrefEncadrerrList;
	}

	public void setPrefEncadrerrList(List<Categorie> prefEncadrerrList) {
		PrefEncadrerrList = prefEncadrerrList;
	}

	public int getNmaxEncadrer() {
		return nmaxEncadrer;
	}

	public void setNmaxEncadrer(int nmaxEncadrer) {
		this.nmaxEncadrer = nmaxEncadrer;
	}

	public int getnEncadrer() {
		return nEncadrer;
	}

	public void setnEncadrer(int nEncadrer) {
		this.nEncadrer = nEncadrer;
	}

	public Encadrant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Encadrant(int nmaxEncadrer) {
		super();
		// TODO Auto-generated constructor stub
		this.nmaxEncadrer= nmaxEncadrer;
		nEncadrer=0;
	}
	
	
}
