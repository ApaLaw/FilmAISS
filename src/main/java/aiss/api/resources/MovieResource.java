package aiss.api.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.api.resources.comparators.ComparatorMovieTitle;
import aiss.api.resources.comparators.ComparatorMovieTitleReversed;
import aiss.model.Comment;
import aiss.model.Movie;
import aiss.model.repository.MapMovieRepository;
import aiss.model.repository.MovieRepository;


@Path("/movies")
public class MovieResource {
	
	/* Singleton */
	private static MovieResource _instance=null;
	MovieRepository repository;
	
	private MovieResource() {
		repository=MapMovieRepository.getInstance();

	}
	
	public static MovieResource getInstance()
	{
		if(_instance==null)
				_instance=new MovieResource();
		return _instance;
	}
	
	
    @GET
    @Produces("application/json")
    public Collection<Movie> getAll(@QueryParam("order") String order,
            @QueryParam("isEmpty") Boolean isEmpty, @QueryParam("name") String name)
    {
        List<Movie> result = new ArrayList<Movie>();
            
        for (Movie movie: repository.getAllMovies()) {
            if (name == null || movie.getTitle().equals(name)) { // Name filter
                if (isEmpty == null // Empty playlist filter
                        || (isEmpty && (movie.getComments() == null || movie.getComments().size() == 0))
                        || (!isEmpty && (movie.getComments() != null && movie.getComments().size() > 0))) {
                    result.add(movie);
                }
            }
        }
            
        if (order != null) { // Order results
            if (order.equals("title")) {
                Collections.sort(result, new ComparatorMovieTitle());
            } else if (order.equals("-title")) {
                Collections.sort(result, new ComparatorMovieTitleReversed());
            } else {
                throw new BadRequestException("The order parameter must be 'title' or '-title'.");
            }
        }

        return result;
    }
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Movie get(@PathParam("id") String id)
	{
		Movie list = repository.getMovie(id);
		
		if (list == null) {
			throw new NotFoundException("The movie wit id="+ id +" was not found");			
		}
		
		return list;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addPlaylist(@Context UriInfo uriInfo, Movie movie) {
		if (movie.getTitle() == null || "".equals(movie.getTitle()))
			throw new BadRequestException("The title of the movie must not be null");
		
		if (movie.getComments()!=null)
			throw new BadRequestException("The comments property is not editable.");

		repository.addMovie(movie);

		// Builds the response. Returns the movie the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(movie.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(movie);			
		return resp.build();
	}

	
	@PUT
	@Consumes("application/json")
	public Response updatePlaylist(Movie movie) {
		Movie oldmovie = repository.getMovie(movie.getId());
		if (oldmovie == null) {
			throw new NotFoundException("The movie with id="+ movie.getId() +" was not found");			
		}
		
		if (movie.getComments()!=null)
			throw new BadRequestException("The comments property is not editable.");
		
		// Update title
		if (movie.getTitle()!=null)
			oldmovie.setTitle(movie.getTitle());
		
		// Update trailer
			if (movie.getUrlTrailer()!=null)
					oldmovie.setUrlTrailer(movie.getUrlTrailer());
				
		// Update soundtrack
			if (movie.getUrlSoundtrack()!=null)
					oldmovie.setUrlSoundtrack(movie.getUrlSoundtrack());
			
		// Update actors
		if (movie.getActors()!=null)
			oldmovie.setActors(movie.getActors());
		
		// Update comments
			if (movie.getComments()!=null)
					oldmovie.setComments(movie.getComments());
				
		// Update filmingloc
			if (movie.getFilmingLocations()!=null)
					oldmovie.setFilmingLocations(movie.getFilmingLocations());
				
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removePlaylist(@PathParam("id") String id) {
		Movie toberemoved=repository.getMovie(id);
		if (toberemoved == null)
			throw new NotFoundException("The movie with id="+ id +" was not found");
		else
			repository.deleteMovie(id);
		
		return Response.noContent().build();
	}
	
	
	@POST	
	@Path("/{playlistId}/{songId}")
	@Produces("application/json")
	public Response addSong(@Context UriInfo uriInfo,@PathParam("playlistId") String movieId, @PathParam("songId") String commentId)
	{				
		
		Movie playlist = repository.getMovie(movieId);
		Comment song = repository.getComment(commentId);
		
		if (playlist==null)
			throw new NotFoundException("The movie with id=" + movieId + " was not found");
		
		if (song == null)
			throw new NotFoundException("The comment with id=" + commentId + " was not found");
		
		if (playlist.getComment(commentId)!=null)
			throw new BadRequestException("The comment is already included in the playlist.");
			
		repository.addComment(movieId, commentId);		

		// Builds the response
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(movieId);
		ResponseBuilder resp = Response.created(uri);
		resp.entity(playlist);			
		return resp.build();
	}
	
	
	@DELETE
	@Path("/{playlistId}/{songId}")
	public Response removeSong(@PathParam("playlistId") String movieId, @PathParam("songId") String commentId) {
		Movie playlist = repository.getMovie(movieId);
		Comment song = repository.getComment(commentId);
		
		if (playlist==null)
			throw new NotFoundException("The movie with id=" + movieId + " was not found");
		
		if (song == null)
			throw new NotFoundException("The comment with id=" + commentId + " was not found");
		
		
		repository.removeComment(movieId, commentId);		
		
		return Response.noContent().build();
	}
}
