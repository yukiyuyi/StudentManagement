package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import domain.Course;
import domain.Grade;
import domain.Student;

@Repository
public interface GradeMapper {
	//增
	int addGrade(Grade grade);
	
	//删
	int deleteGradeBySno(String sno);
	int deleteGradeByCno(String cno);
	int deleteGradeBySnoCno(@Param("sno")String sno,@Param("cno")String cno);
	
	//改,只有修改成绩的权限
	int updateGradeBySnoCno(@Param("sno")String sno,@Param("cno")String cno,@Param("newScore")Double newScore);
	int updateStudents(@Param("oldSno")String oldSno, @Param("newStudent")Student newStudent);
	int updateCourses(@Param("oldCno")String oldCno, @Param("newCourse")Course newCourse);
	
	//查,按学号查，按课程号查，按学号和课程号查
	List<Grade> quryAll();
	List<Grade> queryGradeBySno(String sno);
	Grade queryGradeByCnoSno(@Param("cno")String cno,@Param("sno")String sno);
	List<Grade> queryGradeByCno(String cno);
	
	
	boolean isExistsGradeBySno(String sno);	
	boolean isExistsGradeByCno(String cno);
	boolean isExistsGradeBySnoCno(@Param("sno")String sno,@Param("cno")String cno);

}
