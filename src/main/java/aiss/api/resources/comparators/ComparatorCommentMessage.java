package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Comment;

public class ComparatorCommentMessage implements Comparator<Comment> {

	@Override
	public int compare(Comment c1, Comment c2) {
		return c1.getMessage().compareTo(c2.getMessage());
	}


}
