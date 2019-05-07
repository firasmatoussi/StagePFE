package tn.esprit.PIPFE.Entities;
import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "FormulaireConvention")
@NamedQueries({
    @NamedQuery(name = "FormulaireConvention.findAll", query = "SELECT t FROM FormulaireConvention t order by t.Id desc")
})
public class FormulaireConvention implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int Id;
	private String dateDebut;
	private String dateFin;
	@ManyToOne
	private Entreprise Entreprise;
	
	@OneToOne(mappedBy="FormulaireConvention")
	private Etudiant Etudiant;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		this.Id = id;
	}
	public String getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	public String getDateFin() {
		return dateFin;
	}
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public FormulaireConvention() {
		super();
	}
	
	public Etudiant getEtudiant() {
		return Etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		Etudiant = etudiant;
	}
	public FormulaireConvention(String dateDebut, String dateFin) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	public Entreprise getEntreprise() {
		return Entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		Entreprise = entreprise;
	}
	@Override
	public String toString() {
		return "FormulaireConvention [Id=" + Id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", Entreprise="
				+ Entreprise + ", Etudiant=" + Etudiant + "]";
	}
	public FormulaireConvention(int id, String dateDebut, String dateFin) {
		super();
		Id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
