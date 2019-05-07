package tn.esprit.PIPFE.Entities;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "Entreprise")
@NamedQueries({
    @NamedQuery(name = "Entreprise.findAll", query = "SELECT t FROM Entreprise t")
})
public class Entreprise implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int Id;
	private String Nom;
	private String SiteWeb;
	private String Adresse;
	private String Pays;
	private String NomResponsable;
	private String PrenomResponsable;
	private String EmailResponsable;
	private int Tel;
	
	
	@OneToMany(mappedBy="Entreprise",fetch =FetchType.EAGER)
	private List<FormulaireConvention> FormulaireConvention;
	
	@OneToMany(mappedBy="Entreprise",fetch =FetchType.EAGER)
	private List<EncadrantEntreprise> EncadrantEntreprise;
	
	@OneToMany(mappedBy="Entreprise",fetch =FetchType.EAGER)
	private List<FichePFE> FichePFE;
	
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
	public String getSiteWeb() {
		return SiteWeb;
	}
	public void setSiteWeb(String siteWeb) {
		SiteWeb = siteWeb;
	}
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public String getPays() {
		return Pays;
	}
	public void setPays(String pays) {
		Pays = pays;
	}
	public String getNomResponsable() {
		return NomResponsable;
	}
	public void setNomResponsable(String nomResponsable) {
		NomResponsable = nomResponsable;
	}
	public String getPrenomResponsable() {
		return PrenomResponsable;
	}
	public void setPrenomResponsable(String prenomResponsable) {
		PrenomResponsable = prenomResponsable;
	}
	public String getEmailResponsable() {
		return EmailResponsable;
	}
	public void setEmailResponsable(String emailResponsable) {
		EmailResponsable = emailResponsable;
	}
	public int getTel() {
		return Tel;
	}
	public void setTel(int tel) {
		Tel = tel;
	}


	public List<FormulaireConvention> getFormulaireConvention() {
		return FormulaireConvention;
	}
	public void setFormulaireConvention(List<FormulaireConvention> formulaireConvention) {
		FormulaireConvention = formulaireConvention;
	}
	public List<EncadrantEntreprise> getEncadrantEntreprise() {
		return EncadrantEntreprise;
	}
	public void setEncadrantEntreprise(List<EncadrantEntreprise> encadrantEntreprise) {
		EncadrantEntreprise = encadrantEntreprise;
	}
	public List<FichePFE> getFichePFE() {
		return FichePFE;
	}
	public void setFichePFE(List<FichePFE> fichePFE) {
		FichePFE = fichePFE;
	}
	public Entreprise(String nom, String siteWeb, String adresse, String pays, String nomResponsable,
			String prenomResponsable, String emailResponsable, int tel) {
		super();
		Nom = nom;
		SiteWeb = siteWeb;
		Adresse = adresse;
		Pays = pays;
		NomResponsable = nomResponsable;
		PrenomResponsable = prenomResponsable;
		EmailResponsable = emailResponsable;
		Tel = tel;
	}
	public Entreprise() {
		super();
	}
	@Override
	public String toString() {
		return Nom;
	}
	public Entreprise(String nom, String siteWeb) {
		super();
		Nom = nom;
		SiteWeb = siteWeb;
	}
	public Entreprise(int id, String nom, String siteWeb, String adresse, String pays, String nomResponsable,
			String prenomResponsable, String emailResponsable, int tel) {
		super();
		Id = id;
		Nom = nom;
		SiteWeb = siteWeb;
		Adresse = adresse;
		Pays = pays;
		NomResponsable = nomResponsable;
		PrenomResponsable = prenomResponsable;
		EmailResponsable = emailResponsable;
		Tel = tel;
	}
	
	
	

	
	
	
	
	
	
	
	
	
	

}
