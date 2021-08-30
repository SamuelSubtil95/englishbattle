package fr.humanbooster.fx.englishbattle.servlets;

import java.io.IOException;
import java.util.ArrayList;
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
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/inscription"}, loadOnStartup = 1)
public class InscriptionServlet extends HttpServlet {
	
	private static VilleService villeService = new VilleServiceImpl();
	private static List<Ville> villes = villeService.recupererVilles();
	
	private static NiveauService niveauService = new NiveauServiceImpl();
	private static List<Niveau> niveaux = niveauService.recupererNiveaux();

	private static JoueurService joueurService = new JoueurServiceImpl();
	
	private static final long serialVersionUID = 1L;
	
	//private JoueurService joueurService = new JoueurServiceImpl();

    public InscriptionServlet() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String nom = req.getParameter("NOM");
    	String prenom = req.getParameter("PRENOM");
    	long villeId = Long.parseLong(req.getParameter("VILLE"));
    	long niveauId = Long.parseLong(req.getParameter("NIVEAU"));  	
    	String email = req.getParameter("EMAIL");	
    	String mdp = req.getParameter("MDP");

    	joueurService.ajouterJoueur(email, nom, prenom, mdp, villeService.recupererVille(villeId), niveauService.recupererNiveau(niveauId));
    	req.setAttribute("connected", "Inscription réussie, connectez-vous pour jouer : ");
    	req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("niveaux", niveaux);
		request.setAttribute("villes", villes);
		request.getRequestDispatcher("WEB-INF/inscription.jsp").forward(request, response);
	}
	
	

}
