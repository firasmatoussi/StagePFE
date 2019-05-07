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
@Table(name = "Site")
@NamedQueries({
    @NamedQuery(name = "Site.findAll", query = "SELECT t FROM Site t")
})
public class Site  implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int Id;
	private String Address;
	private int tel;
	private int NbrDep;
	
	@OneToMany(mappedBy="Site",cascade={CascadeType.REMOVE},fetch=FetchType.EAGER)
	private List<Departement>Departement;
	
	@ManyToOne
	private Ecole ecole;
	
	@ManyToMany
	private List<Enseignant> Enseignants;
	
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public int getNbrDep() {
		return NbrDep;
	}
	public void setNbrDep(int nbrDep) {
		NbrDep = nbrDep;
	}
	
	public List<Departement> getDepartement() {
		return Departement;
	}
	public void setDepartement(List<Departement> departement) {
		Departement = departement;
	}
	@Override
	public String toString() {
		return "Site [Id=" + Id + ", Address=" + Address + ", tel=" + tel + ", NbrDep=" + NbrDep + ", Departement="
				+ Departement + "]";
	}
	
	public Site() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Site(String address, int tel, int nbrDep) {
		super();
		Address = address;
		this.tel = tel;
		NbrDep = nbrDep;
		
	}
	public Site(int id, String address, int tel, int nbrDep) {
		super();
		Id = id;
		Address = address;
		this.tel = tel;
		NbrDep = nbrDep;
	}
	
		
	
	
	
	
	

}
