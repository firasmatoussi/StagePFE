package tn.esprit.PIPFE.Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity
@Table(name = "EncadrantEntreprise")
@NamedQueries({
    @NamedQuery(name = "EncadrantEntreprise.findAll", query = "SELECT NEW  tn.esprit.PIPFE.Entities.EncadrantEntreprise(t.Nom,t.Prenom) FROM EncadrantEntreprise t")
})
public class EncadrantEntreprise implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int Id;
	private String Nom;
	private String Prenom;
	private String Email;
	private int Cin;
	private int Tel;
	@ManyToOne
	private Entreprise Entreprise;
	
	
	public EncadrantEntreprise(String nom, String prenom, String email, int cin, int tel) {
		super();
		Nom = nom;
		Prenom = prenom;
		Email = email;
		Cin = cin;
		Tel = tel;
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
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getCin() {
		return Cin;
	}
	public void setCin(int cin) {
		Cin = cin;
	}
	public int getTel() {
		return Tel;
	}
	public void setTel(int tel) {
		Tel = tel;
	}
	public EncadrantEntreprise() {
		super();
	}
	@Override
	public String toString() {
		return "EncadrantEntreprise [Id=" + Id + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Email=" + Email + ", Cin="
				+ Cin + ", Tel=" + Tel + "]";
	}
	public Entreprise getEntreprise() {
		return Entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		this.Entreprise = entreprise;
	}
	public EncadrantEntreprise(String nom, String prenom) {
		super();
		Nom = nom;
		Prenom = prenom;
	}
	
	
	
	

}
