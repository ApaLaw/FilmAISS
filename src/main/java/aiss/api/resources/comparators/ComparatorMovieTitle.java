package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Movie;

public class ComparatorMovieTitle implements Comparator<Movie> {

	@Override
	public int compare(Movie m1, Movie m2) {
		return m1.getTitle().compareTo(m2.getTitle());
	}

}
