package com.fantastic.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.fantastic.web.dao.MemberDao;
import com.fantastic.web.vo.Member;

public class MybatisMemberDao implements MemberDao {

	SqlSessionFactory factory = new SqlFantasticSessionFactory().getSqlSessionFactory();
	
	/*SqlSessionFactory factory = new SqlFantasticSessionFactory()
			.getSqlSessionFactory();*/

	@Override
	public List<Member> getMembers(int page, String field, String query) {

		SqlSession session = factory.openSession();
		MemberDao dao = session.getMapper(MemberDao.class);
		return dao.getMembers(page, field, query);

	}

	@Override
	public List<Member> getMembers(int page) {
		SqlSession session = factory.openSession();
		MemberDao dao = session.getMapper(MemberDao.class);
		return dao.getMembers(page, "TITLE", "");
	}

	public List<Member> getMembers() {
		SqlSession session = factory.openSession();
		MemberDao dao = session.getMapper(MemberDao.class);
		return dao.getMembers(1, "TITLE", "");

	}

	@Override
	public Member getMember(String id) {
		SqlSession session = factory.openSession();
		
		MemberDao dao = session.getMapper(MemberDao.class);
		return dao.getMember(id);
	}

	@Override
	public int addMember(Member member) {
		SqlSession session = factory.openSession();
		MemberDao dao = session.getMapper(MemberDao.class);
		int result = 0;
		try {
			result = session.insert(
					"com.fantastic.web.dao.MemberDao.addMember", member);
			session.commit();
		} finally {
			session.rollback();
			session.close();
		}
		return result;
	}

	@Override
	public int removeMember(String id) {
		SqlSession session = factory.openSession();

		MemberDao dao = session.getMapper(MemberDao.class);
		int result = 0;
		try {
			result = session.delete(
					"com.fantastic.web.dao.MemberDao.removeMember", id);
			session.commit();
		} finally {
			session.rollback();
			session.close();
		}
		return result;
	}

	public int modMember(Member member) {
		SqlSession session = factory.openSession();
		MemberDao dao = session.getMapper(MemberDao.class);
		int result = 0;
		try {
			result = session.update(
					"com.fantastic.web.dao.MemberDao.modMember", member);
			session.commit();
		} finally {
			session.rollback();
			session.close();
		}
		return result;
	}
	
	@Override
	   public int preferLocaMember(Member member) {
	       SqlSession session = factory.openSession();
	        MemberDao dao = session.getMapper(MemberDao.class);
	        int result = 0;
	        try {
	           result = session.update(
	                 "com.fantastic.web.dao.MemberDao.preferLocaMember", member);
	           session.commit();
	        } finally {
	           session.rollback();
	           session.close();
	        }
	        return result;
	   }
}
