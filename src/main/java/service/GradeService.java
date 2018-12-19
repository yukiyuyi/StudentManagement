package service;

import java.util.List;

import org.springframework.stereotype.Service;

import domain.Course;
import domain.Grade;
import domain.Student;

@Service
public interface GradeService {
	//增
//	int addGrade(Grade grade);
	int addGrade(String sno,String cno,Double score);
	//删
	//按学号+课程号删除
	int deleteGradeBySnoCno(String sno,String cno);
	//按学号删除
	int deleteGradeBySno(String sno);
	//按课程号删除
	int deleteGradeByCno(String cno);
	//改
//	int updateGrade(String sno,String cno,Double score);
	int updateGradeBySnoCno(String sno,String cno,Double score);
	int updateStudents(String oldSno,Student newStudent);
	int updateCourses(String oldCno,Course newCourse);
	//查
	List<Grade> queryAll();
	//按成绩+课程号查询
	Grade queryGradeBySnoCno(String sno,String cno);
	//按课程号查询
	List<Grade> queryGradeByCno(String cno);
	//按学号查询
	List<Grade> queryGradeBySno(String sno);
	
	boolean isExistsGradeBySnoCno(String sno,String cno);
	boolean isExistsGradeBySno(String sno);
	boolean isExistsGradeByCno(String cno);
	
}
