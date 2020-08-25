package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Comment;

public class ComparatorCommentMessageReversed implements Comparator<Comment> {

	@Override
	public int compare(Comment c1, Comment c2) {
		return c2.getMessage().compareTo(c1.getMessage());
	}


}
