package tn.esprit.PIPFE.Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue(value = "President")
public class President extends Enseignant implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int nmaxSoutener;
	private int nSoutener;
	
	/*@ManyToMany(mappedBy="")
	private List<Soutenance> Soutenance;*/
	
	public President() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNmaxSoutener() {
		return nmaxSoutener;
	}

	public void setNmaxSoutener(int nmaxSoutener) {
		this.nmaxSoutener = nmaxSoutener;
	}

	public int getnSoutener() {
		return nSoutener;
	}

	public void setnSoutener(int nSoutener) {
		this.nSoutener = nSoutener;
	}

	public President(int nmaxSoutener) {
		super();
		this.nmaxSoutener = nmaxSoutener;
		this.nSoutener = 0;
	}

	
	
	
}
