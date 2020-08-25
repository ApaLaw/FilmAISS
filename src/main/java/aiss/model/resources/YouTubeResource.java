package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.YouTube.Item;
import aiss.model.YouTube.YouTube;

public class YouTubeResource {
	private static final String YT_API_KEY = "API-Key";  // TODO: Change this API KEY for your personal Key
	private static final Logger log = Logger.getLogger(YouTubeResource.class.getName());
	
	
	public static Item getTrailer(String query) throws UnsupportedEncodingException {

		// TODO: Perform search in IMDb
		String queryFormatted = URLEncoder.encode(query, "UTF-8");
		String uri = "https://www.googleapis.com/youtube/v3/search?part=snippet&q=" + queryFormatted + " trailer&type=video&key=" + YT_API_KEY;
		log.log(Level.FINE, "YouTube URI: " + uri);
		
		ClientResource cr = new ClientResource(uri);
		YouTube youtubeSearch = cr.get(YouTube.class);
		Item d = youtubeSearch.getItems().get(0);
		
		return d;
	}
	
}
