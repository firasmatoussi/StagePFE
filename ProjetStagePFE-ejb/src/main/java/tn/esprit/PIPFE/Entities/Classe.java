package tn.esprit.PIPFE.Entities;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
@Entity
@Table(name = "Classe")
@NamedQueries({
    @NamedQuery(name = "Classe.findAll", query = "SELECT t FROM Classe t")
})
public class Classe implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int Id;
	private String Nom;
	@ManyToOne
	private Options Options;
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
	public Options getOption() {
		return Options;
	}
	public void setOption(Options options) {
		Options = options;
	}
	public Classe() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Classe [Id=" + Id + ", Nom=" + Nom + ", Options=" + Options + "]";
	}
	public Classe(String nom) {
		super();
		Nom = nom;
		
	}
	public Classe(int id, String nom) {
		super();
		Id = id;
		Nom = nom;
	}
	public Classe(String nom,Options o) {
		super();
		
		Nom = nom;
		Options=o;
	}
}
