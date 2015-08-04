package com.fantastic.web.dao;

import java.util.List;

import com.fantastic.web.vo.Course;

public interface CourseDao {
   
   public List<Course> getCourse(
         int page,
         String field,
         String query
         );
   
   public List<Course> getCourse(
         int page
         );

   public int addCourse(Course course);
   
   public int removeCourse(String code);
}