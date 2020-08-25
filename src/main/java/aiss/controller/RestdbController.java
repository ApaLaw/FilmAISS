package aiss.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aiss.model.resources.RestdbResource;


/**
 * Servlet implementation class SearchController
 */
public class RestdbController extends HttpServlet {
       
	private static final Logger log = Logger.getLogger(RestdbController.class.getName());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String accessToken = (String) request.getSession().getAttribute("Youtube-token");
		RequestDispatcher rd = null;

		HttpSession MiSession = request.getSession(true);
		
		if(MiSession.getAttribute("aux").equals("1")) {
			String comment = request.getParameter("comentario");
			String nombre = request.getParameter("nombreuser");
			String cadenaCodificada = Base64.getEncoder().encodeToString(comment.getBytes());
			String movieT = MiSession.getAttribute("movie").toString();
			//System.out.println(movieT);
			String cadenaCodificada1 = Base64.getEncoder().encodeToString(movieT.getBytes());
			MiSession.setAttribute("nombre",nombre);
			MiSession.setAttribute("comentario",cadenaCodificada);		
			MiSession.setAttribute("movieTitleS",cadenaCodificada1);			
		}
		
 		//RequestDispatcher rd = null;
		if (accessToken != null && !"".equals(accessToken)) {
			RestdbResource comentarios = new RestdbResource();
			if(comentarios.addCommentary(MiSession.getAttribute("nombre").toString(), MiSession.getAttribute("comentario").toString(), MiSession.getAttribute("movieTitleS").toString())) {
				System.out.println("hola");
				rd = request.getRequestDispatcher("/comments.jsp");
			}
			else {
				rd = request.getRequestDispatcher("/error.jsp");
			}
			
			rd.forward(request, response);
	
		} else {
			String i = "0";
			MiSession.setAttribute("aux", i);
			log.info("Trying to comment without an access token, redirecting to OAuth servlet");
            request.getRequestDispatcher("/AuthController/Youtube").forward(request, response);
		}
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
