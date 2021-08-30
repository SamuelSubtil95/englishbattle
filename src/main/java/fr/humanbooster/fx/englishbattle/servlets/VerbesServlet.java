package fr.humanbooster.fx.englishbattle.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Verbe;
import fr.humanbooster.fx.englishbattle.service.VerbeService;
import fr.humanbooster.fx.englishbattle.service.impl.VerbeServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/verbes"}, loadOnStartup = 1)
public class VerbesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	VerbeService verbeService = new VerbeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Verbe> verbes = new ArrayList<>();
				
		verbes = verbeService.recupererVerbes();
		
		for (Verbe verbe : verbes) {
			System.out.println(verbe);
		}
				
		req.setAttribute("listeDeVerbes", verbes);
		req.getRequestDispatcher("WEB-INF/verbes.jsp").forward(req, resp);
	}
	
}
