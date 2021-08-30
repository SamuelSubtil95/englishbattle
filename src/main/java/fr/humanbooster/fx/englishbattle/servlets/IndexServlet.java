package fr.humanbooster.fx.englishbattle.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.service.JoueurService;
import fr.humanbooster.fx.englishbattle.service.VerbeService;
import fr.humanbooster.fx.englishbattle.service.impl.JoueurServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.VerbeServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexServlet
 */

@WebServlet(urlPatterns = {"/index"}, loadOnStartup = 2)
public class IndexServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static JoueurService joueurService = new JoueurServiceImpl();
	
	private static VerbeService verbeService = new VerbeServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer nbVerbes = verbeService.recupererNbVerbes();
		
		List<Joueur> joueurs = joueurService.recupererJoueurs();
		
		Integer nbJoueurs = joueurs.size();
		
		request.setAttribute("nbJoueurs", nbJoueurs);
		request.setAttribute("nb", nbVerbes);
		request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
	}

}
