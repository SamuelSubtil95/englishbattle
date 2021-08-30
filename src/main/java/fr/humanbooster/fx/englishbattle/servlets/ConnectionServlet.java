package fr.humanbooster.fx.englishbattle.servlets;

import java.io.IOException;

import com.google.protobuf.Message;

import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.service.JoueurService;
import fr.humanbooster.fx.englishbattle.service.PartieService;
import fr.humanbooster.fx.englishbattle.service.impl.JoueurServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.PartieServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/connection"}, loadOnStartup = 1)
public class ConnectionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private static JoueurService joueurService = new JoueurServiceImpl();
	private static PartieService partieService = new PartieServiceImpl();
	
    public ConnectionServlet() {
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("EMAIL");	
		String mdp = request.getParameter("MDP");

		Joueur joueur = joueurService.recupererJoueurParEmailEtMotDePasse(email, mdp);

		if (joueur != null) {
			
			System.out.println("Connexion de " + joueur.getPrenom());
            joueurService.mettreAJourJoueur(joueur.getId(), joueur.getEmail(), joueur.getNom(), joueur.getPrenom(), joueur.getMotDePasse(), joueur.getVille(), joueur.getNiveau(), true);
			
            joueur.setEstEnLigne(true);	
			request.getSession().setAttribute("partie", partieService.ajouterPartie(joueur));
			
			request.setAttribute("joueur", joueur);
			request.getRequestDispatcher("jeu").forward(request, response);
			
		} else {
			request.setAttribute("message", "Identifiants incorrects, veuillez réessayer :"); 
			request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
		}
		
		System.out.println(joueur);
		
	}

}
