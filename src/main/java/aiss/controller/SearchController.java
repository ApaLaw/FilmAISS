package aiss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.YouTube.Item;
import aiss.model.deezer.Datum;
import aiss.model.imdb.Movie;
import aiss.model.mapquest.Location;
import aiss.model.resources.DeezerResource;
import aiss.model.resources.IMDbResource;
import aiss.model.resources.MapQuestResource;
import aiss.model.resources.RestdbResource;
import aiss.model.resources.YouTubeResource;
import aiss.model.restdb.Restdb;

/**
 * Servlet implementation class SearchController
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger log = Logger.getLogger(SearchController.class.getName());
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String query = request.getParameter("searchQuery");
		RequestDispatcher rd = null;
		
		// Search for movies in IMDb
		log.log(Level.FINE, "Searching for IMDb movies that contain " + query);
        IMDbResource imdb = new IMDbResource();
        Movie imdbResult = imdb.getMovie(query);
        log.log(Level.FINE, imdbResult.getYear());
        Datum albumFind = new DeezerResource().getSong(imdbResult.getTitle());
        Item youtubeTrailer = new YouTubeResource().getTrailer('"' + imdbResult.getTitle() + " trailer" + '"');
		System.out.println(query);
		List<Restdb> lsRest = RestdbResource.getComments(imdbResult.getTitle());
        if(imdbResult.getIdIMDB()!=null) {
	        rd = request.getRequestDispatcher("/success.jsp");
	        request.setAttribute("movie", imdbResult); 
	        request.setAttribute("datum", albumFind);
	        request.setAttribute("trailerYT", youtubeTrailer);
	        request.setAttribute("comentariosList", lsRest);
	        
            List<Location> lcoords = new ArrayList<>();
            if (imdbResult.getFilmingLocations() != null) {            	
	            for(int i = 0;i<imdbResult.getFilmingLocations().size();i++) {
	                MapQuestResource lq = new MapQuestResource();
	                lcoords.add(lq.getCoordinate(imdbResult.getFilmingLocations().get(i).getLocation()));
	            }
	        }
            request.setAttribute("lcoordenadas",lcoords);
    	} else {
        log.log(Level.SEVERE, "IMDb object: " + imdbResult);
        rd = request.getRequestDispatcher("/error.jsp");
        }
        
       
        rd.forward(request, response);
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
