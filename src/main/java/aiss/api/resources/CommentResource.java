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

import aiss.api.resources.comparators.ComparatorCommentMessage;
import aiss.api.resources.comparators.ComparatorCommentMessageReversed;
import aiss.api.resources.comparators.ComparatorCommentName;
import aiss.api.resources.comparators.ComparatorCommentNameReversed;
import aiss.model.Comment;
import aiss.model.repository.MapMovieRepository;
import aiss.model.repository.MovieRepository;


@Path("/comments")
public class CommentResource {

	public static CommentResource _instance=null;
	MovieRepository repository;
	
	private CommentResource(){
		repository=MapMovieRepository.getInstance();
	}
	
	public static CommentResource getInstance()
	{
		if(_instance==null)
			_instance=new CommentResource();
		return _instance; 
	}
	
	@GET
	@Produces("application/json")
	public Collection<Comment> getAll(@QueryParam("order") String order, @QueryParam("q") String q)
	{
		List<Comment> result = new ArrayList<Comment>();
        
        for (Comment comment: repository.getAllComments()) {
            if (q == null
            		|| comment.getName().toLowerCase().contains(q.toLowerCase())
            		|| (comment.getMessage() != null && comment.getMessage().toLowerCase().contains(q.toLowerCase())))
            	result.add(comment);
        }
            
        if (order != null) { // Order results
            if (order.equals("name")) {
                Collections.sort(result, new ComparatorCommentName());
            } else if (order.equals("-name")) {
            	Collections.sort(result, new ComparatorCommentNameReversed());
            } else if (order.equals("message")) {
            	Collections.sort(result, new ComparatorCommentMessage());
            } else if (order.equals("-message")) {
            	Collections.sort(result, new ComparatorCommentMessageReversed());
            } else {
                throw new BadRequestException("The order parameter must be 'name', '-name, 'message' or '-message'.");
            }
        }

        return result;
	}
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Comment get(@PathParam("id") String commentId)
	{
		Comment list = repository.getComment(commentId);
		
		if (list == null) {
			throw new NotFoundException("The comment wit id="+ commentId +" was not found");			
		}
		
		return list;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addComment(@Context UriInfo uriInfo, Comment comment) {
		if (comment.getName() == null || "".equals(comment.getName()))
			throw new BadRequestException("The name of the comment must not be null");

		repository.addComment(comment);

		// Builds the response. Returns the movie the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(comment.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(comment);			
		return resp.build();
	}
	
	
	@PUT
	@Consumes("application/json")
	public Response updateSong(Comment comment) {
		Comment oldcomment = repository.getComment(comment.getId());
		if (oldcomment == null) {
			throw new NotFoundException("The comment with id="+ comment.getId() +" was not found");			
		}
		
		// Update name
		if (comment.getName()!=null)
			oldcomment.setName(comment.getName());
		
		// Update message
		if (comment.getMessage()!=null)
			oldcomment.setMessage(comment.getMessage());
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeSong(@PathParam("id") String commentId) {
		Comment toberemoved=repository.getComment(commentId);
		if (toberemoved == null)
			throw new NotFoundException("The comment with id="+ commentId +" was not found");
		else
			repository.deleteComment(commentId);
		
		return Response.noContent().build();
	}
	
}