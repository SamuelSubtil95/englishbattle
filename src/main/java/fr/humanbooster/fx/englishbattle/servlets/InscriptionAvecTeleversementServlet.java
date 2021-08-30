package fr.humanbooster.fx.englishbattle.servlets;

import java.awt.Image;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.business.Niveau;
import fr.humanbooster.fx.englishbattle.business.Ville;
import fr.humanbooster.fx.englishbattle.dao.VilleDao;
import fr.humanbooster.fx.englishbattle.dao.impl.VilleDaoImpl;
import fr.humanbooster.fx.englishbattle.service.JoueurService;
import fr.humanbooster.fx.englishbattle.service.NiveauService;
import fr.humanbooster.fx.englishbattle.service.VilleService;
import fr.humanbooster.fx.englishbattle.service.impl.JoueurServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.NiveauServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.VilleServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig(location="/tmp", fileSizeThreshold=1024*1024, maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
@WebServlet(urlPatterns = {"/inscriptiontele"}, loadOnStartup = 1)   
public class InscriptionAvecTeleversementServlet extends HttpServlet {
	
	private static VilleService villeService = new VilleServiceImpl();
	private static List<Ville> villes = villeService.recupererVilles();
	
	private static NiveauService niveauService = new NiveauServiceImpl();
	private static List<Niveau> niveaux = niveauService.recupererNiveaux();

	private static JoueurService joueurService = new JoueurServiceImpl();
	
	private static final long serialVersionUID = 1L;
	
	//private JoueurService joueurService = new JoueurServiceImpl();
    
	
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String nom = req.getParameter("NOM");
    	String prenom = req.getParameter("PRENOM");
    	long villeId = Long.parseLong(req.getParameter("VILLE"));
    	long niveauId = Long.parseLong(req.getParameter("NIVEAU"));  	
    	String email = req.getParameter("EMAIL");	
    	String mdp = req.getParameter("MDP");
    	
    	//Collection<Part> imagePart = req.getParts();
    	
    	//String fileName = Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();
    	
		Collection<Part> parts = req.getParts();
		   for (Part part : parts) {
		       switch (part.getName()) {
		       case "PHOTO":
		       nom = req.getParameter("PHOTO");
		   break;
		       }
		   }
          
		System.out.println(nom);	    	
    	System.out.println("test");
    	
    	//String fileName = Paths.get(imageCollection.getSubmittedFileName()).getFileName().toString();
    	//String nomImage = 
    	
    	//imageCollection.write(fileName);

    	
    	joueurService.ajouterJoueur(email, nom, prenom, mdp, villeService.recupererVille(villeId), niveauService.recupererNiveau(niveauId));
    	req.setAttribute("connected", "Inscription réussie, connectez-vous pour jouer : ");
    	req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("niveaux", niveaux);
		request.setAttribute("villes", villes);
		request.getRequestDispatcher("WEB-INF/InscriptionAvecTeleversement.jsp").forward(request, response);
	}
	
	

}
