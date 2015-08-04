package com.fantastic.web.dao.mybatis;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.fantastic.web.dao.HelpDao;
import com.fantastic.web.vo.Help;

public class MybatisHelpDao implements HelpDao {

	SqlSessionFactory factory = new SqlFantasticSessionFactory().getSqlSessionFactory();

	@Override
	public List<Help> getHelps(int page, String field, String query) {
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("page", page);
		params.put("field", field);
		params.put("query", query);
		
		SqlSession session = factory.openSession();
		HelpDao helpdao = session.getMapper(HelpDao.class);
		List<Help> list = session.selectList("getHelps", params);
		session.close();

		return list;
	}

	@Override
	public List<Help> getHelp(int page) {
		List<Help> list = getHelps(page, "", "");
		return list;
	}

	@Override
	public int addHelp(Help help) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		int result = 0;
		try {
			result = session.insert("com.fantastic.web.dao.HelpDao.addHelp", help);
			session.commit();
		} finally {
			session.rollback();
			session.close();
		}
		return result;
	}

	@Override
	public int editHelp(Help help) {
		// TODO Auto-generated method stub

		return 0;
	}

	@Override
	public int removeHelp(String code) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		int result = 0;
		try {
			result = session.delete(
					"com.fantastic.web.dao.HelpDao.removeHelp", code);
			session.commit();
		} finally {
			session.rollback();
			session.close();
		}
		return result;
	}

}
