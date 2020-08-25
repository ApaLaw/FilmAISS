package aiss.model.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;

import org.junit.Test;

import aiss.model.YouTube.Item;
import aiss.model.deezer.Datum;
import aiss.model.imdb.Actor;
import aiss.model.imdb.Director;
import aiss.model.imdb.Movie;
import aiss.model.imdb.Writer;
import aiss.model.mapquest.LatLng;
import aiss.model.resources.DeezerResource;
import aiss.model.resources.IMDbResource;
import aiss.model.resources.MapQuestResource;
import aiss.model.resources.RestdbResource;
import aiss.model.resources.YouTubeResource;
import aiss.model.restdb.Restdb;

public class FilmAISSTest {

	@Test
	public void getPeliculaNull() throws UnsupportedEncodingException {
		String query = "asfafaadf";
		IMDbResource imdb = new IMDbResource();
        Movie imdbResult = imdb.getMovie(query);
        
        assertNull("The search didn't return Null", imdbResult);
	}
	
	@Test
	public void getPeliculaOK() throws UnsupportedEncodingException {
		String query = "Avengers: Endgame";
		IMDbResource imdb = new IMDbResource();
        Movie imdbResult = imdb.getMovie(query);
        
        assertNotNull("The search returned Null", imdbResult);
        assertTrue("Title not found", imdbResult.getTitle()!=null);
	}
	
	@Test
	public void getFilmWithoutLocations() throws UnsupportedEncodingException {
		String query = "Rick and Morty";
		IMDbResource imdb = new IMDbResource();
        Movie imdbResult = imdb.getMovie(query);
        
        assertNull("Filming Locations were found", imdbResult.getFilmingLocations());
	}
	
	@Test
	public void getSoundtrackOK() throws UnsupportedEncodingException {
        String query = "Avengers: Endgame";
        DeezerResource dz = new DeezerResource();
        Datum d = dz.getSong(query);
        
        assertNotNull("Soundtrack not found",d);
    }
   
	@Test
    public void getSoundtrackNull() throws UnsupportedEncodingException {
        String query = "saspofdj ñd fsd- fds -fe- - df sad";
        DeezerResource dz = new DeezerResource();
        Datum d = dz.getSong(query);
        
        assertNull("Soundtrack found",d.getLink());
    }
	
	@Test
    public void getTrailer() throws UnsupportedEncodingException {
        String query = "Avengers: Endgame";
        IMDbResource imdb = new IMDbResource();
        Movie imdbResult = imdb.getMovie(query);
        Item youtubeTrailer = new YouTubeResource().getTrailer('"' + imdbResult.getTitle() + " trailer" + '"');
       
        assertNotNull("Trailer not found",youtubeTrailer);
    }
	
	@Test
	public void getLocationOK() throws UnsupportedEncodingException {
        String query= "Sevilla";
        MapQuestResource mp = new MapQuestResource();
        LatLng ll= mp.getCoordinate(query).getLatLng();

        assertNotNull("Location not found",ll);
    }
	
	@Test
	public void getAllFromActors() throws UnsupportedEncodingException {
		String query = "Avengers: Endgame";
        IMDbResource imdb = new IMDbResource();
        Movie imdbResult = imdb.getMovie(query);
        List<Actor> lsAct = imdbResult.getActors();
        
        for (int i = 0; i < lsAct.size(); i++) {
			Actor act = lsAct.get(i);
			assertNotNull("Photo not found", act.getUrlPhoto());
			assertNotNull("Character not found", act.getCharacter());
			assertNotNull("Actor name not found", act.getActorName());
		}
	}

	@Test
	public void getAllFromWriters() throws UnsupportedEncodingException {
		String query = "Avengers: Endgame";
        IMDbResource imdb = new IMDbResource();
        Movie imdbResult = imdb.getMovie(query);
        List<Writer> lsWri = imdbResult.getWriters();
        
        for (int i = 0; i < lsWri.size(); i++) {
        	Writer wri = lsWri.get(i);
			assertNotNull("Id not found", wri.getId());
			assertNotNull("Writer name not found", wri.getName());
		}
	}

	@Test
	public void getAllFromDirectors() throws UnsupportedEncodingException {
		String query = "Avengers: Endgame";
        IMDbResource imdb = new IMDbResource();
        Movie imdbResult = imdb.getMovie(query);
        List<Director> lsDir = imdbResult.getDirectors();
        
        for (int i = 0; i < lsDir.size(); i++) {
        	Director dir = lsDir.get(i);
			assertNotNull("Id not found", dir.getId());
			assertNotNull("Director name not found", dir.getName());
		}
	}
	
	@Test
	public void getAllFromMovie() throws UnsupportedEncodingException {
		String query = "Avengers: Endgame";
        IMDbResource imdb = new IMDbResource();
        Movie imdbResult = imdb.getMovie(query);
        
		assertNotNull("Movie Title not found", imdbResult.getTitle());
		assertFalse("Actors list is empty", imdbResult.getActors().isEmpty());
		assertFalse("Directors list is empty", imdbResult.getDirectors().isEmpty());
		assertFalse("Writers list is empty", imdbResult.getWriters().isEmpty());
		assertNotNull("Movie Plot not found", imdbResult.getSimplePlot());
		assertNotNull("Movie Rate not found", imdbResult.getRated());
		assertNotNull("Movie Rating not found", imdbResult.getRating());
		assertNotNull("Movie Runtime not found", imdbResult.getRuntime());
		assertNotNull("Movie Year not found", imdbResult.getYear());
		assertNotNull("Movie Release Date not found", imdbResult.getReleaseDate());
		assertNotNull("Poster not found", imdbResult.getUrlPoster());
	}
	
	@Test
	public void insertComment() throws IOException {
		RestdbResource comentarios = new RestdbResource();
		String commentCod = Base64.getEncoder().encodeToString("Comentario de prueba".getBytes());
		String titleCod = Base64.getEncoder().encodeToString("Pelicula de prueba".getBytes());

		assertTrue("Comment not inserted", comentarios.addCommentary("Nombre de prueba", commentCod, titleCod));
	}
	
	@Test
	public void getComments() throws IOException {
		List<Restdb> lsRest = RestdbResource.getComments("Pelicula de prueba");
		
		assertFalse("No comments found", lsRest.isEmpty());
	}
	
	@Test
	public void getCommentsNoFilm() throws IOException {
		List<Restdb> lsRest = RestdbResource.getComments("Pelicula inexistente");
		
		assertTrue("Comments found", lsRest.isEmpty());
	}
	
	@Test
	public void getDeezerFrame() throws IOException {
		Datum albumFind = new DeezerResource().getSong("Interstellar");
		
		assertNotNull("Soundtrack title not found", albumFind.getTitle());
		assertNotNull("Soundtrack id not found", albumFind.getId());
	}
}
