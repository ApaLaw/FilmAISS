package aiss.model.repository;

import java.util.Collection;

import aiss.model.Comment;
import aiss.model.Movie;

public interface MovieRepository {
	
	
	// Comments
	public void addComment(Comment c);
	public Collection<Comment> getAllComments();
	public Comment getComment(String commentId);
	public void updateComment(Comment c);
	public void deleteComment(String commentId);
	
	// Movie
	public void addMovie(Movie m);
	public Collection<Movie> getAllMovies();
	public Movie getMovie(String movieId);
	public void updateMovie(Movie m);
	public void deleteMovie(String movieId);
	public Collection<Comment> getAll(String movieId);
	public void addComment(String movieId, String commentId);
	public void removeComment(String movieId, String commentId); 

		
	

}
