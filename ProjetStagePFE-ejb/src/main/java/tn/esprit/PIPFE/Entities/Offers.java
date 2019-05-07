package tn.esprit.PIPFE.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Offers")
@NamedQueries({
    @NamedQuery(name = "Offers.findAll", query = "SELECT t FROM Offers t")
})
public class Offers implements Serializable{
	
	
	@Id
	@GeneratedValue
	private int Id;
	private String nom;
	private String logo;
	private String periode;
	private String description;
	private Date date;
	private String cat;
	public Offers(int id, String nom, String logo, String periode, String description, Date date) {
		super();
		Id = id;
		this.nom = nom;
		this.logo = logo;
		this.periode = periode;
		this.description = description;
		this.date = date;
	}
	public Offers() {
		super();
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getPeriode() {
		return periode;
	}
	public void setPeriode(String periode) {
		this.periode = periode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	
	
	
	
	
	
	

}
