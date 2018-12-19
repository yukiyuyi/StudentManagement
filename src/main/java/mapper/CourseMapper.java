package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import domain.Course;
@Repository
public interface CourseMapper {
	//增加课程
	int addCourse(Course course);
	//删除课程
	int deleteCourseByCno(String cno);
	
	//修改课程
	int UpdateCourse(@Param("oldCno")String oldCno,@Param("newCourse")Course newCourse);
	//查询课程
	List<Course> queryAll();
	Course queryCourseByCno(String cno);
	List<Course> queryCourseByCname(String cname);
	List<Course> queryCourseByCcredit(int ccredit);
	boolean isExistsCourseByCno(String cno);
}
