package fr.humanbooster.fx.englishbattle.servlets;

import java.io.IOException;

import fr.humanbooster.fx.englishbattle.business.Verbe;
import fr.humanbooster.fx.englishbattle.service.VerbeService;
import fr.humanbooster.fx.englishbattle.service.impl.VerbeServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/verbe"}, loadOnStartup = 1)
public class VerbeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	VerbeService verbeService = new VerbeServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Long idVerbe = Long.parseLong(req.getParameter("ID"));
		String baseVerbale = (String) req.getParameter("BASEVERBALE");
		String preterit = (String) req.getParameter("PRETERIT");
		String pPasse = (String) req.getParameter("PPASSE");
		String traduction = (String) req.getParameter("TRADUCTION"); 
		
		verbeService.modifierVerbe(idVerbe, baseVerbale, preterit, pPasse, traduction);
		resp.sendRedirect("verbes");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		Long idVerbe = Long.parseLong(req.getParameter("ID"));
		
		Verbe verbe = verbeService.recupererVerbe(idVerbe);
		
		req.setAttribute("verbe", verbe);		
		req.getRequestDispatcher("WEB-INF/verbe.jsp").forward(req, resp);
	}
	
}
