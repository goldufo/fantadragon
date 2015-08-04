package com.fantastic.web.dao.mybatis;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.fantastic.web.dao.ScrapDao;
import com.fantastic.web.vo.Scrap;

public class MybatisScrapDao implements ScrapDao{

	
	SqlSessionFactory factory = new SqlFantasticSessionFactory().getSqlSessionFactory();

	@Override
	public List<Scrap> getScrap(int page, String field, String query) {
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("page", page);
		params.put("field", field);
		params.put("query", query);
		
		
		SqlSession session = factory.openSession();
		
		/*ReActionDao dao = session.getMapper(ReActionDao.class);		
		
		return dao.getReAction(page, field, query);*/
		
		List<Scrap> list = session.selectList("getScrap", params);
		
		session.close();
		
		return list;
	}

	@Override
	public List<Scrap> getScrap(int page) {
		// TODO 자동 생성된 메소드 스텁
		return null;
	}

	@Override
	public int addScrap(Scrap scrap) {
		
		SqlSession session = factory.openSession(true);
		
		ScrapDao dao = session.getMapper(ScrapDao.class);
	
		
		return dao.addScrap(scrap);
		
		
	}

	@Override
	public List<Scrap> removeScrap(String memberId, String travelCode) {
		
		/*	SqlSession session = factory.openSession();
		
		int result = 0;
		try{
			result  = session.delete("com.fantastic.java.dao.ReActionDao.removeReAction", memberId);
		
			session.commit();
		}
		finally{
			session.rollback();
			session.close();
		}*/
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("memberId", memberId);
		params.put("travelCode", travelCode);		
		
		SqlSession session = factory.openSession();
		
		List<Scrap> listRemove = session.selectList("removeScrap", params);
		
		session.close();
		
		return listRemove;
	}

}
