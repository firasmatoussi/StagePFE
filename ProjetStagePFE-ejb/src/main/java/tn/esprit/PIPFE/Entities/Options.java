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
@Table(name = "Options")
@NamedQueries({
    @NamedQuery(name = "Options.findAll", query = "SELECT t FROM Options t")
})
public class Options implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int Id;
	private String Nom;
	@ManyToOne
	private Departement Departement;
	@OneToMany(mappedBy="Options",cascade={CascadeType.REMOVE},fetch=FetchType.EAGER)
	private List<Classe>Classe= new ArrayList<>();
	
	@ManyToMany
	private List<Enseignant> Enseignants;
	
	
	public List<Enseignant> getEnseignants() {
		return Enseignants;
	}
	public void setEnseignants(List<Enseignant> enseignants) {
		Enseignants = enseignants;
	}
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
	public Departement getDepartement() {
		return Departement;
	}
	public void setDepartement(Departement departement) {
		Departement = departement;
	}
	public List<Classe> getClasse() {
		return Classe;
	}
	public void setClasse(List<Classe> classe) {
		Classe = classe;
	}
	public Options() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Options [Id=" + Id + ", Nom=" + Nom + ", Departement=" + Departement + ", Classe=" + Classe + "]";
	}
	public Options(String nom) {
		super();
		Nom = nom;
	}
	public Options(int id, String nom) {
		super();
		Id = id;
		Nom = nom;
	}
	
	public Options( String nom,Departement d) {
		super();
		Nom = nom;
		Departement=d;
	}

	
}
