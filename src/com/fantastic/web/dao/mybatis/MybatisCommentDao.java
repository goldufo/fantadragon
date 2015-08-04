package com.fantastic.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.fantastic.web.dao.CommentDao;
import com.fantastic.web.vo.Comment;

public class MybatisCommentDao implements CommentDao {

	SqlSessionFactory factory = new SqlFantasticSessionFactory()
			.getSqlSessionFactory();

	@Override
	public List<Comment> getComments(int page, String field, String query) {
	
		SqlSession session = factory.openSession();

		CommentDao dao = session.getMapper(CommentDao.class);

		return dao.getComments(page, field, query);

	}

	@Override
	public List<Comment> getComments(int page) {
		SqlSession session = factory.openSession();

		CommentDao dao = session.getMapper(CommentDao.class);

		return dao.getComments(page);
	}

	@Override
	public int addComment(Comment comment) {
		SqlSession session = factory.openSession();
		
		int result = 0;
		
		try {
			CommentDao dao = session.getMapper(CommentDao.class);
			result =dao.addComment(comment);
			session.commit();
		} finally {
			session.rollback();
			session.close();
		}
		return result;
	}

	@Override
	public int removeComment(String id) {
		SqlSession session = factory.openSession();
		int result = 0;
		try {
			result = session.delete(
					"com.fantastic.web.dao.CommentDao.removeComment", id);
			session.commit();
		} finally {
			session.rollback();
			session.close();
		}
		return result;
	}


}
