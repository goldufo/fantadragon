package com.fantastic.web.dao.mybatis;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;





import com.fantastic.web.dao.TravelDiaryDao;
import com.fantastic.web.vo.TravelDiary;

public class MybatisTravelDiaryDao implements TravelDiaryDao {

	SqlSessionFactory factory = new SqlFantasticSessionFactory().getSqlSessionFactory();
	
	@Override
	public List<TravelDiary> getTravelDiarys(int page, String field, String query) {
		
		SqlSession session = factory.openSession();
		
		TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);		
		
		return dao.getTravelDiarys(page, field, query);
	}
	
	@Override
	public List<TravelDiary> getTravelDiarys(int page) {
		SqlSession session = factory.openSession();
		
		TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);		
		
		return dao.getTravelDiarys(page,"TITLE", "");
	}
	
	@Override
	public List<TravelDiary> getTravelDiarys() {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		
		TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);
		
		return dao.getTravelDiarys(1,"TITLE", "");
	}

	@Override
	public List<TravelDiary> getTravelDiarysOne(String memberID) {
		SqlSession session = factory.openSession();
		
		TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);		
		
		return dao.getTravelDiarysOne(memberID);
	}
	


	@Override
	public int addTravelDiary(TravelDiary travelDiary) {
		SqlSession session = factory.openSession();
		
		
		//TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);
		
		//return dao.addTravelDiary(travelDiary);
		
		int result = 0;
		
		try{
		 result = session.insert(
				"com.fantastic.web.dao.TravelDiaryDao.addTravelDiary",travelDiary);
		
			session.commit();
		}
		finally{
			session.rollback();
			session.close();
		
		}
		
		return result;
		
	}
	   @Override
		public int removeTravelDiary(String code) {
		
		SqlSession session = factory.openSession();
		int result = 0;
		
		try{
		 result = session.delete(
				"com.fantastic.web.dao.TravelDiaryDao.removeTravelDiary",code);
		
			session.commit();
		}
		finally{
			session.rollback();
			session.close();
		
		}
		
		return result;
		
}

	@Override
	public TravelDiary getTravelDiary(String code) {
		// TODO Auto-generated method stub
		return null;
	}


}
