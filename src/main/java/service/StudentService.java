package service;

import java.util.List;
import org.springframework.stereotype.Service;

import domain.Student;

@Service
public interface StudentService {
	//添加一个学生
	int addStudent(Student student);
	
	//删除一个学生
	int deleteStudentBySno(String sno);
	//更新一个学生
	int updateStudent(String oldSno,Student newStudent);
	
	//查询一个学生
	Student queryStudentBySno(String sno);
	
	List<Student> queryAll();
	boolean isExistsCourseBySno(String sno);
	
	List<Student> queryStudentBySsex(String ssex);
	List<Student> queryStudentBySname(String sname);
}
