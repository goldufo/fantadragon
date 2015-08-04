package com.fantastic.web.dao.mybatis;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.fantastic.web.dao.NoticeDao;
import com.fantastic.web.vo.Notice;

public class MybatisNoticeDao implements NoticeDao{
	
	SqlSessionFactory factory = new SqlFantasticSessionFactory()
	.getSqlSessionFactory();

	@Override
	public List<Notice> getNotices(int page, String field, String query) {
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("page", page);
		params.put("field", field);
		params.put("query", query);
		
		SqlSession session = factory.openSession();
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);
		List<Notice> list = session.selectList("getNotices", params);
		session.close();

		return list;
	}

	@Override
	public List<Notice> getNotice(int page) {
		List<Notice> list = getNotices(page, "", "");
		return list;
	}

	@Override
	public int addNotice(Notice notice) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		int result = 0;
		try {
			result = session.insert("com.fantastic.web.dao.NoticeDao.addNotice", notice);
			session.commit();
		} finally {
			session.rollback();
			session.close();
		}
		return result;
	}

	@Override
	public int editNotice(Notice notice) {
		
		return 0;
	}

	@Override
	public int removeNotice(String code) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		int result = 0;
		try {
			result = session.delete(
					"com.fantastic.web.dao.NoticeDao.removeNotice", code);
			session.commit();
		} finally {
			session.rollback();
			session.close();
		}
		return result;
	}

}

