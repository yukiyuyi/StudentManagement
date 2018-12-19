package service;

import java.util.List;

import org.springframework.stereotype.Service;

import domain.Course;

@Service
public interface CourseService {
	//增
	int addCourse(Course course);
	//删
	int deleteCourseByCno(String cno);
	//改
	int updateCourse(String oldCno,Course newCourse) ;
	//查
	Course queryCourseByCno(String cno);
	
	List<Course> queryAll();
	boolean isExistsCourseByCno(String cno);
	
	List<Course> queryCourseByCname(String cname);
	List<Course> queryCourseByCcredit(int ccredit);
}
