package fr.humanbooster.fx.englishbattle.servlets;


import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Ville;
import fr.humanbooster.fx.englishbattle.dao.VilleDao;
import fr.humanbooster.fx.englishbattle.dao.impl.VilleDaoImpl;
import fr.humanbooster.fx.englishbattle.service.JoueurService;
import fr.humanbooster.fx.englishbattle.service.NiveauService;
import fr.humanbooster.fx.englishbattle.service.VerbeService;
import fr.humanbooster.fx.englishbattle.service.VilleService;
import fr.humanbooster.fx.englishbattle.service.impl.JoueurServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.NiveauServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.VerbeServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.VilleServiceImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(urlPatterns = "/init" , loadOnStartup = 1)
public class InitServlet extends HttpServlet{

	private static VilleService villeService = new VilleServiceImpl();
	private static List<Ville> villes = new ArrayList<Ville>();
	
	private static NiveauService niveauService = new NiveauServiceImpl();
	
	private static VerbeService verbeService = new VerbeServiceImpl();
	
	
	
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		verbeService.importerVerbes();
		
		if (villeService.recupererVilles().isEmpty()) {
			villeService.ajouterVille("Lyon");
			villeService.ajouterVille("Grenoble :(");
			villeService.ajouterVille("Villeurbane");
			villeService.ajouterVille("Paris");
			villeService.ajouterVille("Annecy");
			villes = villeService.recupererVilles();
		}
		
		if (niveauService.recupererNiveaux().isEmpty()) {
			niveauService.ajouterNiveau("Débutant");
			niveauService.ajouterNiveau("Intermédiaire");
			niveauService.ajouterNiveau("Confirmé");
		}
		
	}
	
}
