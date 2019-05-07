package tn.esprit.PIPFE.Entities;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

//import javax.persistence.GeneratedValue;
import java.io.Serializable;

@Entity
@DiscriminatorValue(value = "DirecteurDeStage")
public class DirecteurDeStage extends Enseignant implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DirecteurDeStage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DirecteurDeStage(int cin, String nom, String prenom, int tel, String address, String email) {
		super(cin, nom, prenom, tel, address, email);
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
