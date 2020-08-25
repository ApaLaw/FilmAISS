package aiss.model.resources;
 
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.deezer.Datum;
import aiss.model.deezer.Soundtrack;
 
public class DeezerResource {
    private static final Logger log = Logger.getLogger(DeezerResource.class.getName());
   
   
    public Datum getSong(String query) throws UnsupportedEncodingException {
 
        // TODO: Perform search in IMDb
        String queryFormatted = URLEncoder.encode(query, "UTF-8");
        String uri ="https://api.deezer.com/search?q=" + queryFormatted + " soundtrack&limit=1";  
       
        log.log(Level.FINE, "Deezer URI: " + uri);
       
        ClientResource cr = new ClientResource(uri);
        Soundtrack deezerbSearch = cr.get(Soundtrack.class);
        Datum d = new Datum();
        if(deezerbSearch.getData().size() > 0) {
            d = deezerbSearch.getData().get(0);
        }
        //System.out.println("titulo: " + d.getTitle());
        return d;
    }
}
