package tn.esprit.PIPFE.Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Admin implements Serializable{
	
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
	
	@OneToOne
	private Ecole ecole;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int cin, String nom, String prenom, int tel, String address, String email) {
		super();
		Cin = cin;
		Nom = nom;
		Prenom = prenom;
		Tel = tel;
		Address = address;
		Email = email;
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

	public Ecole getEcole() {
		return ecole;
	}

	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
	}

	
	
}
