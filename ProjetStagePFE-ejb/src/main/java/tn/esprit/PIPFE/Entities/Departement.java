package tn.esprit.PIPFE.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.persistence.GeneratedValue;
@Entity
@Table(name = "Departement")
@NamedQueries({
    @NamedQuery(name = "Departement.findAll", query = "SELECT t FROM Departement t")
})
public class Departement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int Id;
	private String Nom;
	private int NbrEmploye;
	@ManyToOne
	private Site Site;
	@OneToMany(mappedBy="Departement",cascade={CascadeType.REMOVE},fetch=FetchType.EAGER)
	private List<Options>Options= new ArrayList<>();
	
	@ManyToMany
	private List<Enseignant> Enseignants;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public int getNbrEmploye() {
		return NbrEmploye;
	}
	public void setNbrEmploye(int nbrEmploye) {
		NbrEmploye = nbrEmploye;
	}
	public Site getSite() {
		return Site;
	}
	public void setSite(Site site) {
		Site = site;
	}
	public List<Options> getOptions() {
		return Options;
	}
	public void setOptions(List<Options> options) {
		Options = options;
	}
	public List<Enseignant> getEnseignants() {
		return Enseignants;
	}
	public void setEnseignants(List<Enseignant> enseignants) {
		Enseignants = enseignants;
	}
	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Departement [Id=" + Id + ", Nom=" + Nom + ", NbrEmploye=" + NbrEmploye + ", Site=" + Site + ", Options="
				+ Options + "]";
	}
	public Departement(String nom, int nbrEmploye) {
		super();
		Nom = nom;
		NbrEmploye = nbrEmploye;
		
	}
	public Departement(String nom, int nbrEmploye, tn.esprit.PIPFE.Entities.Site site) {
		super();
		Nom = nom;
		NbrEmploye = nbrEmploye;
		Site = site;
	}
	
	


	

}
