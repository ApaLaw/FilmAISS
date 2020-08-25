package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Movie;

public class ComparatorMovieTitleReversed implements Comparator<Movie> {

	@Override
	public int compare(Movie m1, Movie m2) {
		return m2.getTitle().compareTo(m1.getTitle());
	}

}
