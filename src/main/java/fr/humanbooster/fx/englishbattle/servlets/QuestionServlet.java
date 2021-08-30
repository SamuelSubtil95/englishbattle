package fr.humanbooster.fx.englishbattle.servlets;

import java.io.IOException;

import fr.humanbooster.fx.englishbattle.business.Partie;
import fr.humanbooster.fx.englishbattle.business.Question;
import fr.humanbooster.fx.englishbattle.business.Verbe;
import fr.humanbooster.fx.englishbattle.service.JoueurService;
import fr.humanbooster.fx.englishbattle.service.PartieService;
import fr.humanbooster.fx.englishbattle.service.QuestionService;
import fr.humanbooster.fx.englishbattle.service.VerbeService;
import fr.humanbooster.fx.englishbattle.service.impl.JoueurServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.PartieServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.QuestionServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.VerbeServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/jeu"}, loadOnStartup = 1)
public class QuestionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static VerbeService verbeService = new VerbeServiceImpl();
	//private static PartieService partieService = new PartieServiceImpl();
	private static QuestionService questionService = new QuestionServiceImpl();
	//private static JoueurService joueurService = new JoueurServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Partie partie = (Partie) req.getSession().getAttribute("partie");
		Verbe verbe = verbeService.recupererVerbeAleatoire();			
		Question question = questionService.ajouterQuestion(partie, verbe);	
		req.getSession().setAttribute("question", question);

		req.getSession().setAttribute("random", Math.random());				
		req.setAttribute("sessionScope", req.getSession());
		req.getRequestDispatcher("WEB-INF/jeu.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String reponsePreterit = req.getParameter("PRETERIT");
		String reponseParticipePasse= req.getParameter("PPASSE");
		
		Question question = (Question) req.getSession().getAttribute("question");
		
		question = questionService.mettreAJourQuestion(question.getId(), reponsePreterit, reponseParticipePasse);

		boolean verif = questionService.verifierReponse(question);
	
		
		// partie en session ? / questio en ssesion ? oui -> ajouter une question 
		
		Partie partie = (Partie) req.getSession().getAttribute("partie");
		
		if (partie != null && question !=null) {
			Verbe verbe = verbeService.recupererVerbeAleatoire();			
			question = questionService.ajouterQuestion(partie, verbe);	
			req.getSession().setAttribute("question", question);
		} 

		if (verif) {
			req.getRequestDispatcher("WEB-INF/jeu.jsp").forward(req, resp);
		} else {
			req.getSession().invalidate();
			req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
		}
		
	}

}
