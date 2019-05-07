package tn.esprit.PIPFE.Entities;
import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;




@Entity
@Table(name = "HeadOfDepartment")
@DiscriminatorValue(value = "HeadOfDeoartement")
@NamedQueries({
    @NamedQuery(name = "HeadOfDepartment.findAll", query = "SELECT t FROM HeadOfDepartment t order by t.Id desc")
})
public class HeadOfDepartment extends Enseignant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HeadOfDepartment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HeadOfDepartment(int cin, String nom, String prenom, int tel, String address, String email) {
		super(cin, nom, prenom, tel, address, email);
		// TODO Auto-generated constructor stub
	}
	
	
	

}
