package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Comment;

public class ComparatorCommentName implements Comparator<Comment> {

	@Override
	public int compare(Comment c1, Comment c2) {
		return c1.getName().compareTo(c2.getName());
	}

}
