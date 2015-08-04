package com.fantastic.web.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.fantastic.web.dao.MemberFileDao;
import com.fantastic.web.vo.MemberFile;

public class MybatisMemberFileDao implements MemberFileDao {

	SqlSessionFactory factory = new SqlFantasticSessionFactory().getSqlSessionFactory();
	
	@Override
	public int addMemberFile(MemberFile memberfile) {
		int result = 0;
		SqlSession session = factory.openSession();
		
		try{
			MemberFileDao memberfiledao = session.getMapper(MemberFileDao.class);
			result = memberfiledao.addMemberFile(memberfile);
			session.commit();
		}
		finally{
			session.rollback();
			session.close();
		}
		return result;
	}

}
