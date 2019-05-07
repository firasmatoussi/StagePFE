package tn.esprit.PIPFE.Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Ecole implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int Id;
	private String logo;
	private String nom;
	private int nbr_site;
	private int tel;
	
	@OneToOne
	private Ecole ecole;
	
	@ManyToMany
	private List<Enseignant> Enseignants;
	
	
	@OneToMany
	private List<Site> Sites;


	public Ecole() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getLogo() {
		return logo;
	}


	public void setLogo(String logo) {
		this.logo = logo;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getNbr_site() {
		return nbr_site;
	}


	public void setNbr_site(int nbr_site) {
		this.nbr_site = nbr_site;
	}


	public int getTel() {
		return tel;
	}


	public void setTel(int tel) {
		this.tel = tel;
	}


	public Ecole getEcole() {
		return ecole;
	}


	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
	}


	public List<Enseignant> getEnseignants() {
		return Enseignants;
	}


	public void setEnseignants(List<Enseignant> enseignants) {
		Enseignants = enseignants;
	}


	public List<Site> getSites() {
		return Sites;
	}


	public void setSites(List<Site> sites) {
		Sites = sites;
	}


	public Ecole(String logo, String nom, int nbr_site, int tel) {
		super();
		this.logo = logo;
		this.nom = nom;
		this.nbr_site = nbr_site;
		this.tel = tel;
	}
	
	

	
	
}
