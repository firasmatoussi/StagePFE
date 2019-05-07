package tn.esprit.PIPFE.Entities;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "Etudiant")
@NamedQueries({
    @NamedQuery(name = "Etudiant.findAll", query = "SELECT t FROM Etudiant t"),
    @NamedQuery(name = "Etudiant.findByEmail", query = "SELECT NEW  tn.esprit.PIPFE.Entities.Etudiant(t.EmailProf) FROM Etudiant t")
})
public class Etudiant implements Serializable {

	@Id
	@GeneratedValue
	private int Id;
	private String Nom;
	private String Prenom;
	private int Cin;
	private String EmailProf;
	private String EmailPerso;
	private int Tel;
	private Boolean Autorise;
	private int creditp;
	private int creditf;
	
	private int demande_enreg;
	private int demade_annul;
	private String demande_text;
	private String champ_annul;
	
	@OneToOne
	private FichePFE FichePfe;
	@OneToOne
	private FormulaireConvention FormulaireConvention;
	@ManyToOne
	private Classe classe;
	
	
	
	
	
	

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
	public Boolean getAutorise() {
		return Autorise;
	}
	public void setAutorise(Boolean autorise) {
		Autorise = autorise;
	}

	public FichePFE getFichePfe() {
		return FichePfe;
	}
	public void setFichePfe(FichePFE fichePfe) {
		FichePfe = fichePfe;
	}

	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	
	
	
	
	
	public int getCreditp() {
		return creditp;
	}
	public void setCreditp(int creditp) {
		this.creditp = creditp;
	}
	public int getCreditf() {
		return creditf;
	}
	public void setCreditf(int creditf) {
		this.creditf = creditf;
	}

	public int getTel() {
		return Tel;
	}
	public void setTel(int tel) {
		Tel = tel;
	}
	public Etudiant() {
		super();
	}



	public FormulaireConvention getFormulaireConvention() {
		return FormulaireConvention;
	}
	public void setFormulaireConvention(FormulaireConvention formulaireConvention) {
		FormulaireConvention = formulaireConvention;
	}
	public int getCin() {
		return Cin;
	}
	public void setCin(int cin) {
		Cin = cin;
	}
	public String getEmailProf() {
		return EmailProf;
	}
	public void setEmailProf(String emailProf) {
		EmailProf = emailProf;
	}
	public String getEmailPerso() {
		return EmailPerso;
	}
	public void setEmailPerso(String emailPerso) {
		EmailPerso = emailPerso;
	}
	@Override
	public String toString() {
		return "Etudiant [Id=" + Id + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Cin=" + Cin + ", EmailProf="
				+ EmailProf + ", EmailPerso=" + EmailPerso + ", Tel=" + Tel + ", Autorise="
				+ Autorise + ", FichePfe=" + FichePfe + ", FormulaireConvention=" + FormulaireConvention + ", classe="
				+ classe + "]";
	}
	public Etudiant(String nom, String prenom, int cin, String emailProf, int tel, int creditp,
			int creditf) {
		super();
		Nom = nom;
		Prenom = prenom;
		Cin = cin;
		EmailProf = emailProf;
		Tel = tel;
		this.creditp = creditp;
		this.creditf = creditf;
	}
	public Etudiant(String emailProf) {
		super();
		EmailProf = emailProf;
	}
	public Etudiant(int id, String nom, String prenom, int cin, String emailProf, String emailPerso, int tel,
			Boolean autorise, int creditp, int creditf, FichePFE fichePfe,
			tn.esprit.PIPFE.Entities.FormulaireConvention formulaireConvention, Classe classe) {
		super();
		Id = id;
		Nom = nom;
		Prenom = prenom;
		Cin = cin;
		EmailProf = emailProf;
		EmailPerso = emailPerso;
		Tel = tel;
		Autorise = autorise;
		this.creditp = creditp;
		this.creditf = creditf;
		FichePfe = fichePfe;
		FormulaireConvention = formulaireConvention;
		this.classe = classe;
	}
	public int getDemande_enreg() {
		return demande_enreg;
	}
	public void setDemande_enreg(int demande_enreg) {
		this.demande_enreg = demande_enreg;
	}
	public int getDemade_annul() {
		return demade_annul;
	}
	public void setDemade_annul(int demade_annul) {
		this.demade_annul = demade_annul;
	}
	public String getDemande_text() {
		return demande_text;
	}
	public void setDemande_text(String demande_text) {
		this.demande_text = demande_text;
	}
	public String getChamp_annul() {
		return champ_annul;
	}
	public void setChamp_annul(String champ_annul) {
		this.champ_annul = champ_annul;
	}
	
	
	
	
	
	
	

	
	
	
	
	

	
	
	
	
	
	
	
	
	

	
	
}
