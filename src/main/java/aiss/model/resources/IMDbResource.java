package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.imdb.Movie;
import aiss.model.imdb.MovieSearch;

public class IMDbResource {

	private static final String IMDB_API_KEY = "4b752629-ea55-4469-95d6-5cedbed0f1ac";  // TODO: Change this API KEY for your personal Key
	private static final Logger log = Logger.getLogger(IMDbResource.class.getName());
	
	
	public Movie getMovie(String query) throws UnsupportedEncodingException {

		// TODO: Perform search in IMDb
		String queryFormatted = URLEncoder.encode(query, "UTF-8");
		String uri = "https://www.myapifilms.com/imdb/idIMDB?title=" + queryFormatted + "&token=" + IMDB_API_KEY + "&format=json&language=en-us&aka=0&business=0&seasons=0&seasonYear=1&technical=0&filter=2&exactFilter=0&limit=1&forceYear=0&trailers=1&movieTrivia=0&awards=0&moviePhotos=0&movieVideos=0&actors=1&biography=0&uniqueName=0&filmography=0&bornAndDead=0&starSign=0&actorActress=0&actorTrivia=0&similarMovies=0&adultSearch=0&goofs=0&keyword=0&quotes=0&fullSize=1&companyCredits=0&filmingLocations=2";
		
		log.log(Level.FINE, "IMDb URI: " + uri);
		
		ClientResource cr = new ClientResource(uri);
		MovieSearch imdbSearch = cr.get(MovieSearch.class);
		Movie d;
		try {
			d = imdbSearch.getData().getMovies().get(0);			
		} catch (Exception e) {
			d = null;
		}
			
		
		return d;
	}
}


