package tn.esprit.PIPFE.Entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Enseignant")
@NamedQueries({
    @NamedQuery(name = "Enseignant.findAll", query = "SELECT t FROM Enseignant t")
})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="t_Employe")
public class Enseignant implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int Id;
	private int Cin;
	private String Nom;
	private String Prenom;
	private int Tel;
	private String Address;
	private String Email;
	@ManyToMany
	private List<FichePFE>FichePFE;
	@ManyToMany
	private List<Soutenance> soutenances;
	
	@ManyToMany(mappedBy="Enseignants")
	private List<Ecole> Ecoles;
	
	@ManyToMany(mappedBy="Enseignants")
	private List<Site> Sites;
	
	@ManyToMany(mappedBy="Enseignants")
	private List<Departement> Departements;
	
	@ManyToMany(mappedBy="Enseignants")
	private List<Options> Options;
	
	@Column(name="t_Employe", insertable = false, updatable = false)
	protected String type_employe;
	
	
	
	
	
	public List<Soutenance> getSoutenances() {
		return soutenances;
	}
	public void setSoutenances(List<Soutenance> soutenances) {
		this.soutenances = soutenances;
	}
	public List<Ecole> getEcoles() {
		return Ecoles;
	}
	public void setEcoles(List<Ecole> ecoles) {
		Ecoles = ecoles;
	}
	public List<Site> getSites() {
		return Sites;
	}
	public void setSites(List<Site> sites) {
		Sites = sites;
	}
	public List<Departement> getDepartements() {
		return Departements;
	}
	public void setDepartements(List<Departement> departements) {
		Departements = departements;
	}
	public List<Options> getOptions() {
		return Options;
	}
	public void setOptions(List<Options> options) {
		Options = options;
	}
	public String getType_employe() {
		return type_employe;
	}
	public void setType_employe(String type_employe) {
		this.type_employe = type_employe;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getCin() {
		return Cin;
	}
	public void setCin(int cin) {
		Cin = cin;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public int getTel() {
		return Tel;
	}
	public void setTel(int tel) {
		Tel = tel;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public List<FichePFE> getFichePFE() {
		return FichePFE;
	}
	public void setFichePFE(List<FichePFE> fichePFE) {
		FichePFE = fichePFE;
	}
	public Enseignant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Enseignant(int cin, String nom, String prenom, int tel, String address, String email) {
		super();
		Cin = cin;
		Nom = nom;
		Prenom = prenom;
		Tel = tel;
		Address = address;
		Email = email;
	}
	
	
	
	
	
	

}
