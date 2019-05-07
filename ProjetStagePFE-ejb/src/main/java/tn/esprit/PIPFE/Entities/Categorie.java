package tn.esprit.PIPFE.Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Categorie")
@NamedQueries({
    @NamedQuery(name = "Categorie.findAll", query = "SELECT t FROM Categorie t")
})
public class Categorie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int Id;
	private String Nom;
	
	@ManyToMany(mappedBy="PrefEncadrerrList")
	private List<Encadrant> Encadrants;
	
	@ManyToMany(mappedBy="PrefValiderList")
	private List<PreValidateur> Prevalidateurs;
	
	
	@ManyToMany(mappedBy="PrefRapporterrList")
	private List<Rapporteur> Rapporteurs;
	
	@OneToMany(mappedBy="Categories")
	private List<FichePFE> FichePfe;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	public List<Rapporteur> getRapporteurs() {
		return Rapporteurs;
	}
	public void setRapporteurs(List<Rapporteur> rapporteurs) {
		Rapporteurs = rapporteurs;
	}
	public Categorie(int id, String nom, List<Encadrant> encadrants, List<PreValidateur> prevalidateurs,
			List<Rapporteur> rapporteurs) {
		super();
		Id = id;
		Nom = nom;
		Encadrants = encadrants;
		Prevalidateurs = prevalidateurs;
		Rapporteurs = rapporteurs;
		
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	
    
	

	public List<FichePFE> getFichePfe() {
		return FichePfe;
	}
	public void setFichePfe(List<FichePFE> fichePfe) {
		FichePfe = fichePfe;
	}
	public List<Encadrant> getEncadrants() {
		return Encadrants;
	}
	public void setEncadrants(List<Encadrant> encadrants) {
		Encadrants = encadrants;
	}
	public List<PreValidateur> getPrevalidateurs() {
		return Prevalidateurs;
	}
	public void setPrevalidateurs(List<PreValidateur> prevalidateurs) {
		Prevalidateurs = prevalidateurs;
	}
	
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categorie(String nom) {
		super();
		Nom = nom;
	}
	@Override
	public String toString() {
		return  Nom ;
	}
	
	
	
}
