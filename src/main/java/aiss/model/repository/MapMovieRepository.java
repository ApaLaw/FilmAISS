package aiss.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import aiss.model.Comment;
import aiss.model.Movie;


public class MapMovieRepository implements MovieRepository {

	Map<String, Movie> movieMap;
	Map<String, Comment> commentMap;
	private static MapMovieRepository instance=null;
	private int index=0;			// Index to create playlists and songs' identifiers.
	
	
	public static MapMovieRepository getInstance() {
		
		if (instance==null) {
			instance = new MapMovieRepository();
			instance.init();
		}
		
		return instance;
	}
	
	public void init() {
		
		movieMap = new HashMap<String,Movie>();
		commentMap = new HashMap<String,Comment>();
		
		// Create comments
		Comment c1 = new Comment();
		c1.setMessage("Los Vengadores: Endgame nunca falla");
		c1.setName("Macarena");
		addComment(c1);

		Comment c2 = new Comment();
		c2.setMessage("Me gustó mucho esta pelicula");
		c2.setName("Barranco");
		addComment(c2);

		Comment c3 = new Comment();
		c3.setMessage("Que chula la pelicula!");
		c3.setName("Paco");
		addComment(c3);

		Comment c4 = new Comment();
		c4.setMessage("Muy intuitiva la página");
		c4.setName("Manuel");
		addComment(c4);

		Comment c5 = new Comment();
		c5.setMessage("Tiene de todo, muy completa");
		c5.setName("Victor");
		addComment(c5);

		Comment c6 = new Comment();
		c6.setMessage("Amazing!");
		c6.setName("Carmen");
		addComment(c6);
		
		// Create movies
		Movie m1 = new Movie();
		m1.setTitle("Avengers: Endgame");
		m1.setUrlSoundtrack("https://www.deezer.com/es/track/669424052");
		m1.setUrlTrailer("https://www.youtube.com/watch?v=TcMBFSGVi1c&t=4s");
		m1.addFilmingLocation("Los Angeles");
		m1.addFilmingLocation("Colorado");
		m1.addFilmingLocation("Nueva York");
		m1.addActor("Robert Downey Jr.");
		m1.addActor("Chris Evans");
		m1.addActor("Scarlett Johansson");
		addMovie(m1);

		Movie m2 = new Movie();
		m2.setTitle("Interstellar");
		m2.setUrlSoundtrack("https://www.deezer.com/es/track/659477712");
		m2.setUrlTrailer("https://www.youtube.com/watch?v=UoSSbmD9vqc");
		m2.addFilmingLocation("Texas");
		m2.addFilmingLocation("Nueva Zelanda");
		m2.addFilmingLocation("Cañón de Colorado");
		m2.addActor("Matthew McConaughey");
		m2.addActor("Anne Hathaway");
		m2.addActor("Matt Damon");
		addMovie(m2);

		Movie m3 = new Movie();
		m3.setTitle("The Hobbit");
		m3.setUrlSoundtrack("https://www.deezer.com/es/track/73135389");
		m3.setUrlTrailer("https://www.youtube.com/watch?v=UoSSbmD9vqc");
		m3.addFilmingLocation("Nueva Jersey");
		m3.addFilmingLocation("Amazonas");
		m3.addFilmingLocation("Río de Janeiro");
		m3.addActor("Ian McKellen");
		m3.addActor("Elijah Wood");
		m3.addActor("Aidan Turner");
		addMovie(m3);
		
		// Add songs to playlists
		addComment(m1.getId(), c1.getId());
		addComment(m1.getId(), c2.getId());
		addComment(m1.getId(), c3.getId());
		addComment(m1.getId(), c4.getId());
		addComment(m3.getId(), c5.getId());
		addComment(m3.getId(), c6.getId());
	}
	
	// Comments related operations
	@Override
	public void addComment(Comment c) {
		String id = "c" + index++;
		c.setId(id);
		commentMap.put(id, c);
	}

	@Override
	public Collection<Comment> getAllComments() {
		return commentMap.values();
	}

	@Override
	public Comment getComment(String commentId) {
		return commentMap.get(commentId);
	}

	@Override
	public void updateComment(Comment c) {
		Comment comment = commentMap.get(c.getId());
		comment.setMessage(c.getMessage());
		comment.setName(c.getName());
	}

	@Override
	public void deleteComment(String commentId) {
		commentMap.remove(commentId);
	}
	
	
	// Movies related operations
	@Override
	public void addMovie(Movie m) {
		String id = "m" + index++;	
		m.setId(id);
		movieMap.put(id,m);
	}

	@Override
	public Collection<Movie> getAllMovies() {
		return movieMap.values();
	}

	@Override
	public Movie getMovie(String movieId) {
		return movieMap.get(movieId);
	}

	@Override
	public void updateMovie(Movie m) {
		movieMap.put(m.getId(), m);
	}

	@Override
	public void deleteMovie(String movieId) {
		movieMap.remove(movieId);		
	}

	@Override
	public void addComment(String movieId, String commentId) {
		Movie movie = getMovie(movieId);
		movie.addComment(commentMap.get(commentId));
	}

	@Override
	public void removeComment(String movieId, String commentId) {
		getMovie(movieId).deleteComment(commentId);		
	}

	@Override
	public Collection<Comment> getAll(String movieId) {
		return getMovie(movieId).getComments();
	}
	
}
