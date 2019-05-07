package tn.esprit.PIPFE.Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = "User.findAll1", query = "SELECT t.Id,t.username,t.password,t.Role,t.id_employe FROM User t"),
    @NamedQuery(name = "User.findAll", query = "SELECT t FROM User t"),
    @NamedQuery(name = "User.find", query = "Select u FROM User u where u.username=:firas and u.password=:walid")
    
    
})
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int Id;
	
	private String username;
	private String password;
	private String Role;
	private int id_employe;
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public int getId_employe() {
		return id_employe;
	}
	public void setId_employe(int id_employe) {
		this.id_employe = id_employe;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password, String role, int id_employe) {
		super();
		this.username = username;
		this.password = password;
		Role = role;
		this.id_employe = id_employe;
	}
	public User(int id, String username, String password, String role, int id_employe) {
		super();
		Id = id;
		this.username = username;
		this.password = password;
		Role = role;
		this.id_employe = id_employe;
	}
	
	
	
	
	
	

}
