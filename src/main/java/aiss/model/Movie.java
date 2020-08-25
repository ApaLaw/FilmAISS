package aiss.model;

import java.util.ArrayList;
import java.util.List;

public class Movie {
	
	private String id;
	private String title;
	private List<String> Actors;
	private List<String> FilmingLocations;
	private String UrlSoundtrack;
	private String UrlTrailer;
	private List<Comment> Comments;
	
	public Movie() {
		
	}
	
	public Movie(String title, List<String> actors, List<String> filmingLocations, String urlSoundtrack,
			String urlTrailer, List<Comment> comments) {
		this.title = title;
		Actors = actors;
		FilmingLocations = filmingLocations;
		UrlSoundtrack = urlSoundtrack;
		UrlTrailer = urlTrailer;
		Comments = comments;
	}
	
	public Movie(String id, String title, List<String> actors, List<String> filmingLocations, String urlSoundtrack,
			String urlTrailer, List<Comment> comments) {
		this.id = id;
		this.title = title;
		Actors = actors;
		FilmingLocations = filmingLocations;
		UrlSoundtrack = urlSoundtrack;
		UrlTrailer = urlTrailer;
		Comments = comments;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getActors() {
		return Actors;
	}
	public void setActors(List<String> actors) {
		Actors = actors;
	}
	public List<String> getFilmingLocations() {
		return FilmingLocations;
	}
	public void setFilmingLocations(List<String> filmingLocations) {
		FilmingLocations = filmingLocations;
	}
	public String getUrlSoundtrack() {
		return UrlSoundtrack;
	}
	public void setUrlSoundtrack(String urlSoundtrack) {
		UrlSoundtrack = urlSoundtrack;
	}
	public String getUrlTrailer() {
		return UrlTrailer;
	}
	public void setUrlTrailer(String urlTrailer) {
		UrlTrailer = urlTrailer;
	}
	public List<Comment> getComments() {
		return Comments;
	}
	public void setComments(List<Comment> comments) {
		Comments = comments;
	}
	
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", Actors=" + Actors + ", FilmingLocations=" + FilmingLocations
				+ ", UrlSoundtrack=" + UrlSoundtrack + ", UrlTrailer=" + UrlTrailer + ", Comments=" + Comments + "]";
	}
	
	
	public Comment getComment(String id) {
		if (Comments==null)
			return null;
		
		Comment comment =null;
		for(Comment c: Comments)
			if (c.getId().equals(id))
			{
				comment=c;
				break;
			}
		
		return comment;
	}
	
	
	
	public void addComment(Comment c) {
		if (Comments==null)
			Comments = new ArrayList<Comment>();
		Comments.add(c);
	}
	
	public void addFilmingLocation(String fl) {
		if (FilmingLocations==null)
			FilmingLocations = new ArrayList<String>();
		FilmingLocations.add(fl);
	}
	
	public void addActor(String a) {
		if (Actors==null)
			Actors = new ArrayList<String>();
		Actors.add(a);
	}
	
	public void deleteComment(String id) {
		Comment c = getComment(id);
		if (c!=null)
			Comments.remove(c);
	}
	
		
}