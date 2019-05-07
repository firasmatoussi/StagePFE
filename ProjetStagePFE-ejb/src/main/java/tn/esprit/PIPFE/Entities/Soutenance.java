package tn.esprit.PIPFE.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue(value = "Soutenance")
public class Soutenance implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int Id;
	private String Sale;
	@Temporal(TemporalType.DATE)
	private Date Date_Debut;
	private Date Date_Fin;
	private int NotePresident;
	
	@OneToOne
	private FichePFE FichePfe;
    
	@ManyToMany(mappedBy="soutenances")
	private List<Enseignant> Enseignants;
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getSale() {
		return Sale;
	}

	public void setSale(String sale) {
		Sale = sale;
	}

	public Date getDate_Debut() {
		return Date_Debut;
	}

	public void setDate_Debut(Date date_Debut) {
		Date_Debut = date_Debut;
	}

	public Date getDate_Fin() {
		return Date_Fin;
	}

	public void setDate_Fin(Date date_Fin) {
		Date_Fin = date_Fin;
	}

	public FichePFE getFichePfe() {
		return FichePfe;
	}

	public void setFichePfe(FichePFE fichePfe) {
		FichePfe = fichePfe;
	}
	
	public Soutenance (){
		 
	}
	
	public int getNotePresident() {
		return NotePresident;
	}


	public Soutenance(String sale, Date date_Debut, Date date_Fin) {
		super();
		Sale = sale;
		Date_Debut = date_Debut;
		Date_Fin = date_Fin;
	}
	
	
}
