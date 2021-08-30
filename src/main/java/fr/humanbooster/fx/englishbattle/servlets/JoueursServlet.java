package fr.humanbooster.fx.englishbattle.servlets;

import java.io.IOException;
import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.service.JoueurService;
import fr.humanbooster.fx.englishbattle.service.impl.JoueurServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/joueurs"}, loadOnStartup = 1)
public class JoueursServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static JoueurService joueurService = new JoueurServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		List<Joueur> joueurs = joueurService.recupererJoueursDuHallOfFame();
		
		req.setAttribute("joueurs", joueurs);
		req.getRequestDispatcher("WEB-INF/joueurs.jsp").forward(req, resp);
	}

}
