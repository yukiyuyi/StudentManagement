package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import domain.Student;

@Repository
public interface StudentMapper {
	int addStudent(Student student);
	int deleteStudentBySno(String sno);
	int updateStudent(@Param("oldSno")String oldSno,@Param("newStudent")Student newStudent);
	Student queryStudentBySno(String sno);
	List<Student> queryAll();
	boolean isExistsStudentBySno(String sno);

	//根据sname查询学生
	List<Student> queryStudentBySname(String sname);
	//根据ssex查询学生
	List<Student> queryStudentBySsex(String ssex);
}
