package com.fantastic.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.fantastic.web.dao.CourseDao;
import com.fantastic.web.vo.Course;

public class MybatisCourseDao implements CourseDao{

   SqlSessionFactory factory = new SqlFantasticSessionFactory()
   .getSqlSessionFactory();

   @Override
   public List<Course> getCourse(int page, String field, String query) {
   
      SqlSession session = factory.openSession();

      CourseDao dao = session.getMapper(CourseDao.class);

      return dao.getCourse(page, field, query);

   }

   @Override
   public List<Course> getCourse(int page) {
      // TODO 자동 생성된 메소드 스텁
      return null;
   }

   @Override
   public int addCourse(Course course) {
      SqlSession session = factory.openSession();
      int result = 0;
      try {
         result = session.insert(
               "com.fantastic.web.dao.CourseDao.addCourse", course);
         session.commit();
      } finally {
         session.rollback();
         session.close();
      }
      return result;
   }

   @Override
   public int removeCourse(String code) {
      SqlSession session = factory.openSession();
      int result = 0;
      try {
         result = session.delete(
               "com.fantastic.web.dao.CourseDao.removeCourse", code);
         session.commit();
      } finally {
         session.rollback();
         session.close();
      }
      return result;
   }
}