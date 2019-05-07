package tn.esprit.PIPFE.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.esprit.PIPFE.Entities.Categorie;
import tn.esprit.PIPFE.Entities.Classe;
import tn.esprit.PIPFE.Entities.Departement;
import tn.esprit.PIPFE.Entities.Encadrant;
import tn.esprit.PIPFE.Entities.EncadrantEntreprise;
import tn.esprit.PIPFE.Entities.Enseignant;
import tn.esprit.PIPFE.Entities.Entreprise;
import tn.esprit.PIPFE.Entities.Etudiant;
import tn.esprit.PIPFE.Entities.FichePFE;
import tn.esprit.PIPFE.Entities.FormulaireConvention;
import tn.esprit.PIPFE.Entities.Offers;
import tn.esprit.PIPFE.Entities.Options;
import tn.esprit.PIPFE.Entities.PreValidateur;
import tn.esprit.PIPFE.Entities.President;
import tn.esprit.PIPFE.Entities.Rapporteur;
import tn.esprit.PIPFE.Entities.Site;
import tn.esprit.PIPFE.Entities.User;



@Stateless
public class CrudServices implements CrudRemote{

	@PersistenceContext(unitName="ProjetStagePFE-ejb")
	EntityManager em;
	

	/* ----------------------------------- Classe -------------------------------------------------- */ 

	@Override
	public void AjouterClasse (Classe  h) {
		em.persist(h);		
	}

	@Override
	public Classe  AfficherClasse (int id) {
		Classe  f= em.find(Classe .class,id);
		return (f);
	}

	@Override
	public void ModifierClasse (Classe  h) {
		em.merge(h);
		
	}

	@Override
	public List getAllClasses() {
        return em.createNamedQuery("Classe .findAll", Classe .class).getResultList();

	}

	@Override
	public void deleteClasse (Classe  h) {
		if (!em.contains(h)) {
            h = em.merge(h);
        }

        em.remove(h);	
	}
	
	/* ----------------------------------- Site -------------------------------------------------- */ 
	
	@Override
	 public void AjouterSite (Site h)
	 {
		 em.persist(h);
	 }
	@Override
	 public Site AfficherSite (int id)
	 {
		Site s= em.find(Site.class,id);
		return (s);
		 
	 }
	@Override
	 public void ModifierSite (Site h)
	 {
		 em.merge(h);
		 
	 }
	@Override
	 public List getAllSites() {
		return em.createNamedQuery("Site.findAll", Site.class).getResultList();
	    }
	@Override
	 public void deleteSite(Site h) {
	        if (!em.contains(h)) {
	            h = em.merge(h);
	        }

	        em.remove(h);
	    }
	
	
	/* ----------------------------------- Departments -------------------------------------------------- */ 
	
	
	@Override
	public void AjouterDepartement(Departement h) {
		 em.persist(h);		
	}

	@Override
	public Departement AfficherDepartement(int id) {
		Departement s= em.find(Departement.class,id);
		return (s);
	}

	@Override
	public void ModifierDepartement(Departement h) {
		 em.merge(h);
		
	}

	@Override
	public List getAllDepartement() {
		 return em.createNamedQuery("Departement.findAll", Departement.class).getResultList();
	}

	@Override
	public void deleteDepartement(Departement h) {
		 if (!em.contains(h)) {
	            h = em.merge(h);
	        }

	        em.remove(h);
	}
	
	/* ----------------------------------- Options -------------------------------------------------- */ 
	
	@Override
	public void AjouterOptions(Options h) {
		 em.persist(h);		
	}

	@Override
	public Options AfficherOptions(int id) {
		Options s= em.find(Options.class,id);
		return (s);
	}

	@Override
	public void ModifierOptions(Options h) {
		 em.merge(h);
		
	}

	@Override
	public List getAllOptions() {
		 return em.createNamedQuery("Options.findAll", Options.class).getResultList();
	}

	@Override
	public void deleteOptions(Options h) {
		 if (!em.contains(h)) {
	            h = em.merge(h);
	        }

	        em.remove(h);	
	}
	
	@Override
	public void Affecterdepasit(int ids, int idd) {
		Site s=em.find(Site.class, ids);
		Departement d=em.find(Departement.class, idd);
		d.setSite(s);
		
	}

	@Override
	public void Affecteropadep(int idd, int ido) {
		Departement d=em.find(Departement.class, idd);
		Options s=em.find(Options.class, ido);
		s.setDepartement(d);		
	}

	@Override
	public void Affecterclassaop(int ido, int idc) {
		Options s=em.find(Options.class, ido);
		Classe d=em.find(Classe.class, idc);
		d.setOption(s);		
	}
	
	public void Affecteretuaclass(int idc ,int ide){
		Classe c=em.find(Classe.class, idc);
		Etudiant e=em.find(Etudiant.class, ide);
		e.setClasse(c);	
		
	}
	

	
	/* ----------------------------------- Enseigants -------------------------------------------------- */ 	
	@Override
	public void AjouterRapporteur(Rapporteur R) {
		em.persist(R);
		
	}
	@Override
	public void AjouterPreValidateur(PreValidateur P) {
		em.persist(P);
		
	}
	@Override
	public void AjouterEncadrant(Encadrant E) {
		em.persist(E);
		
	}
	@Override
	public void AjouterPresident(President P) {
		em.persist(P);
		
	}
	
	@Override
	public void AjouterEnseignant(Enseignant E) {
		em.persist(E);
		
	}
	
	@Override
	public void AffecterCatEncadrant(int idE, int idC) {
		Encadrant ens=em.find(Encadrant.class, idE);
		Categorie cat=em.find(Categorie.class, idC);
		
		ens.getPrefEncadrerrList().add(cat);
		cat.getEncadrants().add(ens);	
	}
	
	@Override
	public void AffecterCatPrevalidateur(int idE, int idC) {
		PreValidateur ens=em.find(PreValidateur.class, idE);
		Categorie cat=em.find(Categorie.class, idC);
		ens.getPrefValiderList().add(cat);
		cat.getPrevalidateurs().add(ens);	
		
	}
	@Override
	public void AffecterEnsAFiche(int idf, int ide) {
		Enseignant cat=em.find(Enseignant.class, ide);
		FichePFE ens=em.find(FichePFE.class, idf);
		
		cat.getFichePFE().add(ens);
		ens.getEnseignant().add(cat);
	}
	
	@Override
	public void AffecterRoleToRapporteur(int Ide) {
		Enseignant e=em.find(Enseignant.class, Ide);
		Rapporteur R= new Rapporteur(e.getCin());
		em.persist(R);
	}
	@Override
	public void AffecterRoleToEncadrant(int Ide) {
		Enseignant e=em.find(Enseignant.class, Ide);
		Encadrant R= new Encadrant(e.getCin());
		em.persist(R);
		
	}
	@Override
	public void AffecterRoleToPreValidateur(int Ide) {
		Enseignant e=em.find(Enseignant.class, Ide);
		PreValidateur R= new PreValidateur(e.getCin());
		em.persist(R);
	}
	@Override
	public void AffecterRoleToPresident(int Ide) {
		Enseignant e=em.find(Enseignant.class, Ide);
		President R= new President(e.getCin());
		em.persist(R);
		
	}
	
	
	/* ----------------------------------- Head of Departments -------------------------------------------------- */ 
	
	/* ----------------------------------- Categories -------------------------------------------------- */ 
	@Override
	public void AjouterCategorie(Categorie c) {
		em.persist(c);
		
	}
	
	public List getAllCategories(){
		 return em.createNamedQuery("Categorie.findAll",Categorie.class).getResultList();

	}
	/* ----------------------------------- Directeur de Stages -------------------------------------------------- */
	
	
	/* ----------------------------------- Ecole -------------------------------------------------- */ 
	
	/* ----------------------------------- Fiche Pfe -------------------------------------------------- */ 
	@Override
	public int AjouterFichePfe(FichePFE f) {
		em.persist(f);
		return f.getId();
		
	}
	
	@Override
	public FichePFE FichePFE(int id) {
		FichePFE s= em.find(FichePFE.class,id);
		return (s);
	}
	@Override
	public void ModifierFichePFE(FichePFE f) {
		em.merge(f);
		
	}
	@Override
	public List getAllFichePFE() {
		 return em.createNamedQuery("FichePFE.findAll",FichePFE.class).getResultList();

	}
	@Override
	public void deleteFichePFE(FichePFE f) {
		if (!em.contains(f)) {
            f = em.merge(f);
        }

        em.remove(f);	
		
	}
	
	@Override
	public void AffecterEtudiantFiche(int idE, int idF) {
		Etudiant e=em.find(Etudiant.class, idE);
		FichePFE fiche=em.find(FichePFE.class, idF);
		
		//fiche.setEtudiant(e);
		e.setFichePfe(fiche);
	}
	
	
	@Override
	public void AffecterEntrepriseFicheCat(int idc,int idE, int idF) {
		Categorie c=em.find(Categorie.class, idc);
		Entreprise e=em.find(Entreprise.class, idE);
		FichePFE fiche=em.find(FichePFE.class, idF);
		
		fiche.setEntreprise(e);
		fiche.setCategories(c);
	}
	
	
	
/* ----------------------------------- Entreprise -------------------------------------------------- */ 
	
	
	@Override
	public void AjouterEntreprise(Entreprise e) {
		 em.persist(e);		
		
	}
	@Override
	public Entreprise Entreprise(int id) {
		Entreprise s= em.find(Entreprise.class,id);
		return (s);
	}
	@Override
	public void ModifierEntreprise(Entreprise e) {
		em.merge(e);
		
	}
	@Override
	public List getAllEntreprise() {
		 return em.createNamedQuery("Entreprise.findAll",Entreprise.class).getResultList();

	}
	@Override
	public void deleteEntreprise(Entreprise e) {
		if (!em.contains(e)) {
            e = em.merge(e);
        }

        em.remove(e);
	}
	
	@Override
	public List getOffers() {
		 return em.createNamedQuery("Offers.findAll",Offers.class).getResultList();

	}
	
	
/* ----------------------------------- Encadrant-Entreprise ---------------------------------------- */ 
	
	@Override
	public void AjouterEncadrantEntreprise(tn.esprit.PIPFE.Entities.EncadrantEntreprise e) {
		em.persist(e);	
		
	}
	@Override
	public tn.esprit.PIPFE.Entities.EncadrantEntreprise EncadrantEntreprise(int id) {
		tn.esprit.PIPFE.Entities.EncadrantEntreprise s= em.find(tn.esprit.PIPFE.Entities.EncadrantEntreprise.class,id);
		return (s);
	}
	@Override
	public void ModifierEncadrantEntreprise(tn.esprit.PIPFE.Entities.EncadrantEntreprise e) {
		em.merge(e);
		
	}
	@Override
	public List getAllEncadrantEntreprise() {
		 return em.createNamedQuery("EncadrantEntreprise.findAll", tn.esprit.PIPFE.Entities.EncadrantEntreprise.class).getResultList();

	}
	@Override
	public void deleteEncadrantEntreprise(tn.esprit.PIPFE.Entities.EncadrantEntreprise e) {
		if (!em.contains(e)) {
            e = em.merge(e);
        }

        em.remove(e);
	}
	
	@Override
	public void Affecterencadaent(int ide, int idec) {
		tn.esprit.PIPFE.Entities.Entreprise e=em.find(tn.esprit.PIPFE.Entities.Entreprise.class, ide);
		EncadrantEntreprise f=em.find(EncadrantEntreprise.class, idec);
		f.setEntreprise(e);
		
	}


	
	/* -----------------------------------  Formulaire de Convention -------------------------------------------- */ 
	public int AjouterConvention(FormulaireConvention h) {
		em.persist(h);
		return h.getId();
	}
	@Override
	public FormulaireConvention AfficherConvention(int id) {
		FormulaireConvention f= em.find(FormulaireConvention.class,id);
		return (f);
	}
	@Override
	public void ModifierConvention(FormulaireConvention h) {
		 em.merge(h);
		
	}
	@Override
	public List getAllConvention() {
        return em.createNamedQuery("FormulaireConvention.findAll", FormulaireConvention.class).getResultList();

	}
	@Override
	public void deleteConvention(FormulaireConvention h) {
		if (!em.contains(h)) {
            h = em.merge(h);
        }

        em.remove(h);	
	}
	
	
	
	
	
	
	
	/* ----------------------------------- Etudiant -------------------------------------------------- */ 


	
	@Override
	public void AjouterEtudiant(Etudiant h) {
		em.persist(h);		
	}

	@Override
	public Etudiant AfficherEtudiant(int id) {
		Etudiant f= em.find(Etudiant.class,id);
		return (f);
	}

	@Override
	public void ModifierEtudiant(Etudiant h) {
		em.merge(h);
		
	}

	@Override
	public List getAllEtudiant() {
        return em.createNamedQuery("Etudiant.findAll", Etudiant.class).getResultList();

	}

	@Override
	public void deleteEtudiant(Etudiant h) {
		if (!em.contains(h)) {
            h = em.merge(h);
        }

        em.remove(h);	
	}
	
	
	@Override
	public int ajouterUser(User u) {
		em.persist(u);	
		return u.getId();
	}
	@Override
	public void modifierUser(User u) {
		em.merge(u);
		
	}
	@Override
	public void supprimererUser(User u) {
		if (!em.contains(u)) {
            u = em.merge(u);
        }

        em.remove(u);				
	}
	@Override
	public List afficherUser() {
		return em.createNamedQuery("User.findAll",User.class).getResultList();
		
	}
	
	@Override
	public User loginH(String username, String password) {
		ArrayList<User> liste = (ArrayList<User> )(em.createNamedQuery("User.findAll",User.class).getResultList());
		for(User u : liste) { 
			if((u.getUsername().matches(username)) && (u.getPassword().matches(password)))
				return u;
		}
		return null;
	}
	
	public User getUserByEmP(String username,String password){
		TypedQuery<User> query=em.createQuery("Select u FROM User u "
				+"where u.username=:firas and "
				+"u.password=:mt",User.class);
		query.setParameter("firas", username);
		query.setParameter("mt", password);
		
		User user=null;
		try{
		user = query.getSingleResult();
		System.out.println(user);
		
		}catch(NoResultException e){
			System.out.println("fuck dawla w dostour");
		}
		return user;
	}
	
	public void UpdatePass(int ide,String s){
		User e= em.find(User.class,ide);
		e.setPassword(s);
	}
	@Override
	public User getUserById(int id) {
		User u;
		u=em.find(User.class, id);
		return u ;
	}
	public void AffecterEtuUser(int ide,int idu){
		
		Entreprise e=em.find(Entreprise.class, ide);
		
		User f=em.find(User.class, idu);
		f.setId_employe(e.getId());
		
	}
	
	public User login(String username , String password) { 
			
		ArrayList<User> liste = (ArrayList<User> )(em.createNamedQuery("User.findAll",User.class).getResultList());
		for(User u : liste) { 
			if((u.getUsername().matches(username)) && (u.getPassword().matches(password)))
				return u;
		}
		return null;
	
	}
	
	public List<String> RechercherEmail(){
		List<String> emails=new ArrayList<String>();
		
		List<Etudiant> etus= em.createNamedQuery("Etudiant.findByEmail",Etudiant.class).getResultList();
		for(Etudiant e:etus){
			emails.add(e.getEmailProf());
		
	}
		return emails;
	}
	
public void modificationMajeur(int idF,String fun,String prob){
		
		FichePFE e=em.find(FichePFE.class, idF);
		
		e.setModmaj(true);
		e.setFunmaj(fun);
		e.setProbmaj(prob);
		
	}
public void modificationMineur(int idF,String titre,String desc,String keys){
	
	FichePFE e=em.find(FichePFE.class, idF);
	
	e.setTitre(titre);
	e.setDescription(desc);
	e.setMotsCle(keys);
	
}

public void UpdateEmailPerso(int ide,String s){
	Etudiant e= em.find(Etudiant.class,ide);
	e.setEmailPerso(s);
}
public void UpdateTel(int ide,int tel){
	Etudiant e= em.find(Etudiant.class,ide);
	e.setTel(tel);
}

public void EnvoyerDemande(int ide,String s){
	Etudiant e= em.find(Etudiant.class,ide);
	e.setDemande_enreg(1);
	e.setDemande_text(s);
}

public void EnvoyerAnnulation(int ide,String s){
	Etudiant e= em.find(Etudiant.class,ide);
	e.setChamp_annul(s);
	e.setDemade_annul(1);
}
@Override
public void Affecterformaetu(int ide, int idf) {
	Etudiant e=em.find(Etudiant.class, ide);
	FormulaireConvention f=em.find(FormulaireConvention.class, idf);
	//f.setEtudiant(e);
	e.setFormulaireConvention(f);
	
}
@Override
public void Affecterformaent(int ide, int idf) {
	Entreprise e=em.find(Entreprise.class, ide);
	
	FormulaireConvention f=em.find(FormulaireConvention.class, idf);
	f.setEntreprise(e);
	
}


	
	


}
