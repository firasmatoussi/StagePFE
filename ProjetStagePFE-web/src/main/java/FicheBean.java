import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.enterprise.inject.Default;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.servlet.http.Part;

import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.UploadedFile;

import tn.SendingMail;
import tn.esprit.PIPFE.Entities.Categorie;
import tn.esprit.PIPFE.Entities.Entreprise;
import tn.esprit.PIPFE.Entities.Etudiant;
import tn.esprit.PIPFE.Entities.FichePFE;
import tn.esprit.PIPFE.Entities.Offers;
import tn.esprit.PIPFE.Entities.User;
import tn.esprit.PIPFE.Services.CrudRemote;

/**
 * 
 */

/**
 * @author Firas
 *
 */
@ManagedBean
@SessionScoped
@Default
public class FicheBean {
	//Fiche PFE
	private String titre;
	private String desc;
	private String prob;
	private String func;
	private String keys;
	private String date;
	private Entreprise entre;
	private Categorie cate;

	//Login
	private String login;
	private String password;
	private String role;
	private Boolean LoggedIn;
	private User user;
	private User s;
	private List<Entreprise> entreprises;
	private List<Categorie> categories;
	private List<Offers> offers;
	private Offers offe;
	private String userna;
	private String register;
	private Boolean test=false;
	private List<FichePFE> fiches;
	private String nomCat;
	
	
	private Part file;
	private String folder="C:\\Users\\Firas\\Desktop\\4InfoB1\\JEE\\JEE\\ProjetStagePFE\\ProjetStagePFE-web\\src\\main\\webapp\\resources\\";
	
	
	
	
	
	
	

	public User getS() {
		return s;
	}

	public void setS(User s) {
		this.s = s;
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public String getNomCat() {
		return nomCat;
	}

	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}

	@EJB
	CrudRemote cs;
	
	
	
	
	public List<FichePFE> afficherfiche(){
		List<FichePFE> f1=new ArrayList<>();
		fiches=cs.getAllFichePFE();
		for(FichePFE d:fiches){
			if(d.getEtudiant().getEmailProf().equals("firas.matoussi@esprit.tn")){
				f1.add(d);
			}
		}
		return f1;	
	}
	
	
	
	
	////////// Ajouter Fiche
	public void ajouterFiche(){
		//cs.AjouterFichePfe(new FichePFE(titre, desc, prob, func ,keys,date));
		/*int selectedEntre=entre.getId();
		int selectedCat=cate.getId();
		System.out.println(selectedCat);
		System.out.println(selectedEntre);*/
		
		cs.AffecterEntrepriseFicheCat(2,6,cs.AjouterFichePfe(new FichePFE(titre, desc, prob, func ,keys,date)) );
		System.out.println("Done");
	}
	
	
	///////// Combo Entreprise
	public List<Entreprise> entreprisefiche(){
		entreprises=cs.getAllEntreprise();
		System.out.println(login);
		return entreprises;
		
	}
	
	
	
	public void onTabChange(TabChangeEvent event) {
        FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
         
    public void onTabClose(TabCloseEvent event) {
        FacesMessage msg = new FacesMessage("Tab Closed", "Closed tab: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
	
	
	
	//////////Display Offers
	public List<Offers> Display(){
		offers=cs.getOffers();
		
		
		if(test==false){
			test=true;
			return offers;
		}
		else{
			String categ = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("form10:cater");
			Logger.getLogger(FicheBean.class.getName()).log(Level.INFO, "Category:", categ);
			System.out.println(categ);
			
			List<Offers> offers1=new ArrayList<Offers>();
			for(Offers c:offers){
				if(c.getCat().equals(categ)){
					offers1.add(c);
					test=true;
					
				}
				}
			test=true;
			return offers1;	
			
		}
		
	}
	

	
	
	///////// Categories
	public List<Categorie> categoriefiche(){
		categories=cs.getAllCategories();
		System.out.println(login);
		return categories;
	}
	
	
	public void upload() throws IOException {
		Scanner s = new Scanner(file.getInputStream());
		String fileContent = s.useDelimiter("\\A").next();
		s.close();
		
		System.out.println(fileContent);
		
		Files.write(Paths.get("C:\\Users\\Firas\\Desktop\\4InfoB1\\JEE\\JEE\\ProjetStagePFE\\ProjetStagePFE-web\\src\\main\\webapp\\resources\\"+file.getSubmittedFileName()), fileContent.getBytes(), StandardOpenOption.CREATE);
	}
    
	
	
	/////////Login
	/*public String doLogin(){
		String navigateTo="";
		user=cs.getUserByEmP(login, password);
		System.out.println(login);
		
		if(user!=null && user.getRole().equals("etudiant")){
			navigateTo="Student?faces-redirect=true";
			
			LoggedIn=true;
		}
		return navigateTo;
	}*/
	
	public String doLogin1(){
		String navigateTo="";
		user =cs.login(login, password);
		s=user;
		if (user != null){
		//Role=user.getRole();
		//id_employe=user.getId_employe();
		}
		
		if (user != null && user.getRole().equals("etudiant")){
			navigateTo="Student?faces-redirect=true";
			LoggedIn=true;
		}
		else if (user != null && user.getRole().equals("")){
			navigateTo="";
			LoggedIn=true;
		}
		else if (user != null && user.getRole().equals("")){
			navigateTo="";
			LoggedIn=true;
		}
		
		
		
		return navigateTo;
	}
	
	/////////Registration
	public void registration(){
		List<Etudiant> etus=cs.getAllEtudiant();
		for(Etudiant e:etus){
			if(e.getEmailProf().equals(register)){
				SendingMail sn=new SendingMail("Hello Sir \n You have been registred to ESI Manager", register, "Registration");
				sn.envoyer();
				User u=new User(register, generer(), "etudiant", e.getId());
				int b=cs.ajouterUser(u);
			}
		}
	}
	
	
	///////// Mot de passe généré
	public String generer(){
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 9;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	    return generatedString;
		}
	
	
	////////////// Log out
	public String doLogout(){
		this.LoggedIn=false;
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "Login?faces-redirect=true";
	}

	
	
	public Boolean getTest() {
		return test;
	}




	public void setTest(Boolean test) {
		this.test = test;
	}




	public List<FichePFE> getFiches() {
		return fiches;
	}


	public void setFiches(List<FichePFE> fiches) {
		this.fiches = fiches;
	}


	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getProb() {
		return prob;
	}

	public void setProb(String prob) {
		this.prob = prob;
	}
	
	

	public List<Offers> getOffers() {
		return offers;
	}
	public void setOffers(List<Offers> offers) {
		this.offers = offers;
	}
	public String getFunc() {
		return func;
	}

	public void setFunc(String func) {
		this.func = func;
	}

	public String getKeys() {
		return keys;
	}

	public void setKeys(String keys) {
		this.keys = keys;
	}

	


	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getLoggedIn() {
		return LoggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		LoggedIn = loggedIn;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Entreprise getEntre() {
		return entre;
	}
	public void setEntre(Entreprise entre) {
		this.entre = entre;
	}
	public Categorie getCate() {
		return cate;
	}
	public void setCate(Categorie cate) {
		this.cate = cate;
	}
	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public String getUserna() {
		return userna;
	}

	public void setUserna(String userna) {
		this.userna = userna;
	}

	public Offers getOffe() {
		return offe;
	}

	public void setOffe(Offers offe) {
		this.offe = offe;
	}

	public List<Entreprise> getEntreprises() {
		return entreprises;
	}
	
	public List<Categorie> getCategories() {
		return categories;
	}
	
	public void setEntreprises(List<Entreprise> entreprises) {
		this.entreprises = entreprises;
	}
	
	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}
	
	
	
}
