package com.fantastic.web.dao;

import java.util.List;

import com.fantastic.web.vo.Comment;

public interface CommentDao {
	
	public List<Comment> getComments(
			int page,
			String field,
			String query
			);
	
	public List<Comment> getComments(
			int page
			);
	
		public int addComment(Comment comment);
	
	public int removeComment(String code);
}

