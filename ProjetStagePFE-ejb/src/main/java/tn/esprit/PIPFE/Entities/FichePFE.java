package tn.esprit.PIPFE.Entities;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "FichePFE")
@NamedQueries({
    @NamedQuery(name = "FichePFE.findAll", query = "SELECT t FROM FichePFE t")
})
public class FichePFE  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int Id;
	private String Titre;
	private String Description;
	private String Problematique;
	private String Fonctionnalite;
	private String MotsCle;
	@OneToOne(mappedBy="FichePfe")
	private Etudiant Etudiant;
	private String Date;
	
	private String funmaj;
	private String probmaj;
	private float NoteRapporteur;
	private float NoteEncadrant;
	private Boolean Prevalider;
	@ManyToMany(mappedBy="FichePFE")
	private List<Enseignant>Enseignant;
	private Boolean Accepte;
	@OneToOne(mappedBy="FichePfe")
	private Soutenance Soutenannce;
	@ManyToOne
	private Entreprise Entreprise;

	
	@ManyToOne
	private Categorie Categories;
	private Boolean depot;
	
	private Boolean modmaj;
	
	

	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getTitre() {
		return Titre;
	}
	public void setTitre(String titre) {
		Titre = titre;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getProblematique() {
		return Problematique;
	}
	public void setProblematique(String problematique) {
		Problematique = problematique;
	}
	public String getFonctionnalite() {
		return Fonctionnalite;
	}
	public void setFonctionnalite(String fonctionnalite) {
		Fonctionnalite = fonctionnalite;
	}
	public String getMotsCle() {
		return MotsCle;
	}
	public void setMotsCle(String motsCle) {
		MotsCle = motsCle;
	}
	public Etudiant getEtudiant() {
		return Etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		Etudiant = etudiant;
	}
	
	
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public float getNoteRapporteur() {
		return NoteRapporteur;
	}
	public void setNoteRapporteur(float noteRapporteur) {
		NoteRapporteur = noteRapporteur;
	}
	public float getNoteEncadrant() {
		return NoteEncadrant;
	}
	public void setNoteEncadrant(float noteEncadrant) {
		NoteEncadrant = noteEncadrant;
	}
	public Boolean getPrevalider() {
		return Prevalider;
	}
	public void setPrevalider(Boolean prevalider) {
		Prevalider = prevalider;
	}
	public List<Enseignant> getEnseignant() {
		return Enseignant;
	}
	public void setEnseignant(List<Enseignant> enseignant) {
		Enseignant = enseignant;
	}
	public Boolean getAccepte() {
		return Accepte;
	}
	public void setAccepte(Boolean accepte) {
		Accepte = accepte;
	}
	
	public Soutenance getSoutenannce() {
		return Soutenannce;
	}
	public void setSoutenannce(Soutenance soutenannce) {
		Soutenannce = soutenannce;
	}
	
	

	@Override
	public String toString() {
		return "FichePFE [Id=" + Id + ", Titre=" + Titre + ", Description=" + Description + ", Problematique="
				+ Problematique + ", Fonctionnalite=" + Fonctionnalite + ", MotsCle=" + MotsCle + ", depot=" + depot
				+ ", modmaj=" + modmaj + "]";
	}
	public Categorie getCategories() {
		return Categories;
	}
	public void setCategories(Categorie categories) {
		Categories = categories;
	}
	public FichePFE(){
		
	}
	
	
	public FichePFE(String titre, String description, String problematique, String fonctionnalite, String motsCle,String date) {
		
		super();
		Titre = titre;
		Description = description;
		Problematique = problematique;
		Fonctionnalite = fonctionnalite;
		MotsCle = motsCle;
		Date = date;
		
	}
	public Entreprise getEntreprise() {
		return Entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		Entreprise = entreprise;
	}
	public String getFunmaj() {
		return funmaj;
	}
	public void setFunmaj(String funmaj) {
		this.funmaj = funmaj;
	}
	public String getProbmaj() {
		return probmaj;
	}
	public void setProbmaj(String probmaj) {
		this.probmaj = probmaj;
	}
	public Boolean getDepot() {
		return depot;
	}
	public void setDepot(Boolean depot) {
		this.depot = depot;
	}
	public Boolean getModmaj() {
		return modmaj;
	}
	public void setModmaj(Boolean modmaj) {
		this.modmaj = modmaj;
	}
	
	
	
	
	
	
	
	
	

}
