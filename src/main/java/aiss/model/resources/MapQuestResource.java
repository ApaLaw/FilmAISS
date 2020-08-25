package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.mapquest.Location;
import aiss.model.mapquest.MapQuest;

public class MapQuestResource {

	private static final String MAP_API_KEY = "pQR5UIv2NKpo5UH9RGMrDKOuylEMRBwy";  // TODO: Change this API KEY for your personal Key
	private static final Logger log = Logger.getLogger(MapQuestResource.class.getName());
	
	
	public Location getCoordinate(String query) throws UnsupportedEncodingException {

		// TODO: Perform search in IMDb
		String queryFormatted = URLEncoder.encode(query, "UTF-8");
		String uri = "http://open.mapquestapi.com/geocoding/v1/address?key=" + MAP_API_KEY + "&location=" + queryFormatted;
		
		log.log(Level.FINE, "IMDb URI: " + uri);
		
		ClientResource cr = new ClientResource(uri);
		MapQuest coordenadas = cr.get(MapQuest.class);
		Location c = coordenadas.getResults().get(0).getLocations().get(0);
		
		return c;
	}

}
