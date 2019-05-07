package tn.esprit.PIPFE.Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue(value = "Prevalidateur")
public class PreValidateur extends Enseignant implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int nmaxValider;
	private int nValider;
	@ManyToMany
	private List<Categorie> PrefValiderList;
   


	public int getNmaxValider() {
		return nmaxValider;
	}



	public void setNmaxValider(int nmaxValider) {
		this.nmaxValider = nmaxValider;
	}



	public int getnValider() {
		return nValider;
	}



	public void setnValider(int nValider) {
		this.nValider = nValider;
	}



	public List<Categorie> getPrefValiderList() {
		return PrefValiderList;
	}



	public void setPrefValiderList(List<Categorie> prefValiderList) {
		PrefValiderList = prefValiderList;
	}



	public PreValidateur() {
		super();
		// TODO Auto-generated constructor stub
	}



	public PreValidateur(int nmaxValider) {
		super();
		this.nmaxValider = nmaxValider;
		this.nValider = 0;
		
	}

	
	
	
	
	


	
	
	
}
