package tn.esprit.PIPFE.Services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.PIPFE.Entities.Categorie;
import tn.esprit.PIPFE.Entities.Classe;
import tn.esprit.PIPFE.Entities.Departement;
import tn.esprit.PIPFE.Entities.Encadrant;
import tn.esprit.PIPFE.Entities.Enseignant;
import tn.esprit.PIPFE.Entities.Etudiant;
import tn.esprit.PIPFE.Entities.FichePFE;
import tn.esprit.PIPFE.Entities.FormulaireConvention;
import tn.esprit.PIPFE.Entities.Options;
import tn.esprit.PIPFE.Entities.PreValidateur;
import tn.esprit.PIPFE.Entities.President;
import tn.esprit.PIPFE.Entities.Rapporteur;
import tn.esprit.PIPFE.Entities.Site;
import tn.esprit.PIPFE.Entities.User;
import tn.esprit.PIPFE.Entities.Entreprise;


@Remote
public interface CrudRemote {
	

	void AjouterSite (Site h);
	Site AfficherSite (int id);
	void ModifierSite (Site h);
	List getAllSites();
	void deleteSite(Site h);
	
	void AjouterDepartement (Departement h);
	Departement AfficherDepartement (int id);
	void ModifierDepartement (Departement h);
	List getAllDepartement();
	void deleteDepartement(Departement h);
	
	void AjouterClasse (Classe h);
	Classe AfficherClasse (int id);
	void ModifierClasse (Classe h);
	List getAllClasses();
	void deleteClasse(Classe h);
	
	void AjouterOptions (Options p);
	Options AfficherOptions (int id);
	void ModifierOptions (Options h);
	List getAllOptions();
	void deleteOptions(Options h);
	
	void Affecterdepasit(int ids ,int idd);
	void Affecteropadep(int idd ,int ido);
	void Affecterclassaop(int ido ,int idc);
	void Affecteretuaclass(int idc ,int ide);
	
	void AjouterRapporteur(Rapporteur rr);
	void AjouterPreValidateur(PreValidateur P);
	void AjouterEncadrant(Encadrant E);
	void AjouterPresident(President P);
	void AjouterEnseignant(Enseignant E);
	
	
	void AffecterCatEncadrant(int idE, int idC);
	void AffecterCatPrevalidateur(int idE, int idC);
	void AffecterEnsAFiche(int idf, int ide);
	void AffecterRoleToRapporteur(int Ide);
	void AffecterRoleToEncadrant(int Ide);
	void AffecterRoleToPreValidateur(int Ide);
	void AffecterRoleToPresident(int Ide);

	
	
	/* ---------------------------------- Firas----------------------------------- */
	
	// Categorie
	void AjouterCategorie(Categorie c);
	List getAllCategories();	
	
	// Fiche Pfe
	int AjouterFichePfe(FichePFE f);
	FichePFE FichePFE (int id);
	void ModifierFichePFE(FichePFE f);
	List getAllFichePFE();
	void deleteFichePFE(FichePFE f);
	
	
	 
	 
	 // Entreprise
	void AjouterEntreprise (Entreprise e);
	Entreprise Entreprise (int id);
	void ModifierEntreprise (Entreprise e);
	List getAllEntreprise();
	void deleteEntreprise(Entreprise e);
	List getOffers();
		
	// Encadrant Entreprise
	void AjouterEncadrantEntreprise (tn.esprit.PIPFE.Entities.EncadrantEntreprise e);
	tn.esprit.PIPFE.Entities.EncadrantEntreprise EncadrantEntreprise (int id);
	void ModifierEncadrantEntreprise(tn.esprit.PIPFE.Entities.EncadrantEntreprise e);
	List getAllEncadrantEntreprise();
	void deleteEncadrantEntreprise(tn.esprit.PIPFE.Entities.EncadrantEntreprise e);
		
	//Formulaire de Convention
	int AjouterConvention (FormulaireConvention h);
	FormulaireConvention AfficherConvention (int id);
	void ModifierConvention (FormulaireConvention h);
	List getAllConvention();
		void deleteConvention(FormulaireConvention h);
		
	// Etudiant
	void AjouterEtudiant (Etudiant h);
	Etudiant AfficherEtudiant (int id);
	void UpdateEmailPerso(int ide,String s);
	void ModifierEtudiant (Etudiant h);
	List getAllEtudiant();
	void deleteEtudiant(Etudiant h);

	// Formulaire a Etudiant
	void Affecterformaetu(int ide ,int idf);
		
	// Formulaire a Entreprise
	void Affecterformaent(int ide, int idf);
		
	// Fiche a Etudiant
	void AffecterEtudiantFiche(int idE, int idF);
		
	// Fiche a Entreprise et Cat
	void AffecterEntrepriseFicheCat(int idc,int idE, int idF);
		
	// Encadrant-Ent a Entreprsie
	void Affecterencadaent(int ide, int idec);
	
	//*************** CRUD USER**************
	public int ajouterUser(User u);
	public void modifierUser(User u);
	public void supprimererUser(User u);
	User getUserByEmP(String username,String password);
	public List afficherUser();
	void AffecterEtuUser(int ide,int idu);
	void UpdatePass(int ide,String s);
	void UpdateTel(int ide,int tel);
	void modificationMajeur(int idF,String fun,String prob);
	void modificationMineur(int idF,String titre,String desc,String keys);
	User loginH(String username, String password);
	
	
	public User getUserById(int id) ;
	public User login(String username , String password);
	List<String> RechercherEmail();
	void EnvoyerDemande(int ide,String s);
	void EnvoyerAnnulation(int ide,String s);
	

}
